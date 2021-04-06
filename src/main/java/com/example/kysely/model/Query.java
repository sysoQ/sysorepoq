package com.example.kysely.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.kysely.model.Question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Query {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private String name;

    @ManyToOne
    @JsonIgnoreProperties ("questions") 
    @JoinColumn(name = "questionid")
	 private Question question;

     public Query () {
     }


     public Query (String name, Question question) {
		super();
		this.name = name;
		this.question = question;
     }

    public Long getId() { 
    	return id;
    }
     
     public void setId(Long Id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", name=" + name + ", question=" + question + "]";
	}

	
}