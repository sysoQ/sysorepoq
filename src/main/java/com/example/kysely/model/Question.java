
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	
	/*@JsonIgnore
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "question")
	private List<Query> queries;*/
	
	
	@ManyToOne
    @JsonBackReference
    @JoinColumn
    public Query query;
	
	
	public Question() {}
		
	public Question(String text, Query query) {
		super();
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
	
	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + "]";
	}  
	
	
}