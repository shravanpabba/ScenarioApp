package com.list.app.repository;

import com.list.app.model.ScenarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class JdbcRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterjdbcTemplate;

	public List<ScenarioModel> getAllScenarios(String pattern, List<Integer> keywordIds) {

		String sql = null;
		MapSqlParameterSource parameters = new MapSqlParameterSource();

		if (pattern != null) {
			sql = "select  a.id as scenarioId ,a.SCENARIO_NAME as scenarioName,a.SCENARIO_DESC as scenarioDesc ,a.REL_PATH as relPath ,a.FILE_NAME as fileName,\n"
					+ "(select LISTAGG(keyword_name, ' ; ')\n"
					+ "WITHIN GROUP (ORDER BY keyword_name)  from Keyword where id in ( select keyword_id from SCENARIO_KEYWORD where scenario_id=a.id)) as scenarioParams\n"
					+ "from scenarios a \n" + "where a.id in \n" + "(select scenario_id \n" + "from SCENARIO_KEYWORD \n"
					+ "where keyword_id in(:keyIds) \n" + "group by scenario_id having count(scenario_id) =:count)";

			parameters.addValue("pattern", keywordIds);
		} else {
			sql = "select  a.id as scenarioId ,a.SCENARIO_NAME as scenarioName,a.SCENARIO_DESC as scenarioDesc ,a.REL_PATH as relPath ,a.FILE_NAME as fileName,\n"
					+ "(select LISTAGG(keyword_name, ' ; ')\n"
					+ "WITHIN GROUP (ORDER BY keyword_name)  from Keyword where id in ( select keyword_id from SCENARIO_KEYWORD where scenario_id=a.id)) as scenarioParams\n"
					+ "from scenarios a \n" + "where a.id in \n" + "(select scenario_id \n" + "from SCENARIO_KEYWORD \n"
					+ "where keyword_id in(:keyIds) \n" + "group by scenario_id having count(scenario_id) =:count)";

			parameters.addValue("keyIds", keywordIds);
			parameters.addValue("count", keywordIds.size());
		}

		return namedParameterjdbcTemplate.query(sql, parameters, new RowMapper<ScenarioModel>() {
			@Override
			public ScenarioModel mapRow(ResultSet resultSet, int i) throws SQLException {
				return toScenarioModel(resultSet);
			}
		});

	}

	private ScenarioModel toScenarioModel(ResultSet rs) throws SQLException {
		ScenarioModel scenarioModel = new ScenarioModel();
		scenarioModel.setScenarioId(rs.getInt(1));
		scenarioModel.setScenarioName(rs.getString(2));
		scenarioModel.setScenarioDesc(rs.getString(3));
		scenarioModel.setRelPath(rs.getString(4));
		scenarioModel.setFileName(rs.getString(5));
		scenarioModel.setScenarioParams(rs.getString(6));

		return scenarioModel;
	}
}
