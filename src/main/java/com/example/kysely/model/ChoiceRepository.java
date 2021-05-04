package com.example.kysely.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChoiceRepository extends CrudRepository<Choice, Long> {
	public List<Choice> findByQuestion(Question question);
	
}
