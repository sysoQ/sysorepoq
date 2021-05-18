package com.example.kysely.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.kysely.model.Question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Query {
	@Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private String name;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "query")
    @JsonManagedReference //Parent level 
    private List<Question> questionList;

    
   
    
    public Query () {
     }


     public Query (String name) {
		super();
		this.name = name;
		
     }

    public Long getId() { 
    	return id;
    }
     
     public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	@Override
	public String toString() {

		
		return name;
	}

	
	
}