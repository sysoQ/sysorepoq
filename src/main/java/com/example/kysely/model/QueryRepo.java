package com.example.kysely.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QueryRepo extends CrudRepository<Query, Long> { 
  
	List<Query> findAll();
	
	List<Query> findById(String id); 
	
	List<Query> findByName(String name);
}