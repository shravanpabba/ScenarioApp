package com.list.app.repository;

import com.list.app.entity.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyWordRepository extends CrudRepository<Keyword, Long> {

	List<Keyword> findById(int id);

	List<Keyword> findAllByCatidIn(List<Integer> catIds);

}
