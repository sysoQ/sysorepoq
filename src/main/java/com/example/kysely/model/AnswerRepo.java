package com.example.kysely.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface AnswerRepo extends CrudRepository<Answer, Long> {  

	List<Answer> findByQuestion(Question question);  
	

}