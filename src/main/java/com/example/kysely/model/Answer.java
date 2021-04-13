
package com.example.kysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String content;
	
	@ManyToOne
    @JsonBackReference
    @JoinColumn
    public Question question;
	
	
	public Answer() {}


	public Answer(String content, Question question) {
		super();
		this.content = content;
		this.question = question;
	}


	public Long getAnswerId() {
		return answerId;
	}


	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", content=" + content + ", question=" + question + "]";
	}
	
	
}