package com.example.kysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Choice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long choiceId;
	private String choiceContent;
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("choice")
	private Question question;
    
	// constructor with parameters
	public Choice(String choiceContent, Question question) {
		super();
		this.choiceContent = choiceContent;
		this.question = question;
	}

	// constuctor without parameters
	public Choice() {

	}
    
	// getters and setters
	public Long getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(Long choiceId) {
		this.choiceId = choiceId;
	}

	public String getChoiceContent() {
		return choiceContent;
	}

	public void setContent(String choiceContent) {
		this.choiceContent = choiceContent;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}