
package com.example.kysely.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.kysely.model.Query;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text; 
	private QuestionType type;
	
	
	@ManyToOne
    @JsonBackReference
    @JoinColumn
    public Query query; 
	
	@JsonIgnoreProperties("question")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers; 
	@JsonIgnoreProperties("question")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Choice> choices;

	
	
	public Question() {}
		
	public Question(QuestionType type, String text, Query query) {
		super();
		this.type = type;
		this.text = text; 
		this.query = query; 
	}  
	
	public Question(Query query) {
		super();
		this.query = query; 
	} 
	
	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}  
	
	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}
	
	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		
		
		return "Question [id=" + id + " query" + query + ", text=" + text + "]";
	}  
	
	
}