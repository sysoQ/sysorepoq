package com.example.kysely.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface QuestionRepo extends CrudRepository<Question, Long> {  
	 
	List<Question> findByQuery(Query query);
	

}