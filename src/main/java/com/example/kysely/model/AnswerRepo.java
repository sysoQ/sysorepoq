package com.example.kysely.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;



public interface AnswerRepo extends CrudRepository<Answer, Long> {  

	//List<Question> findAll();  
}