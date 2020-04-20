package com.list.app.repository;

import com.list.app.entity.Description;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescriptionRepository extends CrudRepository<Description, Long> {

	List<Description> findById(int id);
	List<Description> findAllByKeyidIn(List<Integer> keyIds);
}
