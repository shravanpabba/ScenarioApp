package com.list.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.list.app.entity.ScenarioKeyword;

@Repository
public interface ScenarioKeyWordRepository extends CrudRepository<ScenarioKeyword, Long> {
	
	List<ScenarioKeyword> findByScenarioKeywordIdIn(List<Integer> keywordIdList);

}
