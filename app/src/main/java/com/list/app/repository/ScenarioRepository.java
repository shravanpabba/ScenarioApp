package com.list.app.repository;

import com.list.app.entity.Scenarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenarios, Long> {

	List<Object> findAllByIdIn(List<Integer> id);

	/*@Query(value="select  a.id as scenarioId ,a.SCENARIO_NAME as scenarioName,a.SCENARIO_DESC as scenarioDesc ,a.REL_PATH as relPath ,a.FILE_NAME as fileName,\n" +
			"(select LISTAGG(keyword_name,  \" ; \")\n" +
			"WITHIN GROUP (ORDER BY keyword_name)  from Keyword where id in ( select keyword_id from SCENARIO_KEYWORD where scenario_id=a.id)) as scenarioParams\n" +
			"from scenarios a \n" +
			"where a.id in \n" +
			"(select scenario_id \n" +
			"from SCENARIO_KEYWORD \n" +
			"where keyword_id in(1,5) \n" +
			"group by scenario_id having count(scenario_id) =2)")
	List<Scenarios> findByQuery();*/
}
