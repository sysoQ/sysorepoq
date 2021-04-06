package com.example.kysely.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository; 

public interface QuestionRepo extends CrudRepository<Question, Long> { 

}