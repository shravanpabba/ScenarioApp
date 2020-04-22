package com.list.app.repository;

import com.list.app.entity.Scenarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenarios, Long> {

	List<Scenarios> findAllById(int id);
}
