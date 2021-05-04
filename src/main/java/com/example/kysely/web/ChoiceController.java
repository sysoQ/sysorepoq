package com.example.kysely.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController; 

import com.example.kysely.model.AnswerRepo;
import com.example.kysely.model.Choice; 
import com.example.kysely.model.ChoiceRepository; 
import com.example.kysely.model.Question; 
import com.example.kysely.model.QuestionRepo;


@CrossOrigin
@RestController
public class ChoiceController {

	@Autowired
	private QuestionRepo questionRepository;

	@Autowired
	private ChoiceRepository choiceRepository;
	
	//list all choices by question
	@GetMapping("/questions/{id}/choices")
	public  @ResponseBody List<Choice> findOptionsByQuestion(@PathVariable("id") Long questionId){
		Question question = questionRepository.findById(questionId).orElse(null);
		return (List<Choice>) choiceRepository.findByQuestion(question);
	}
	
	//list all choices
	@GetMapping("/choices")
	public @ResponseBody List<Choice> findAllChoices(){
		return (List<Choice>) choiceRepository.findAll();
	}
		
	//save question
	//method returns list of choices for each question that has radiobutton/multiple choice
	@PostMapping("/choices")
	public List<Choice> saveChoice(@RequestBody List<Choice> choices) {
		List <Choice> savedChoices = new ArrayList<Choice>();
		for (int i = 0; i < choices.size(); i++) {
			Question question = questionRepository.findById(choices.get(i).getQuestion().getId()).orElse(null);
			Choice choice = new Choice(choices.get(i).getChoiceContent(), question);
			choiceRepository.save(choice);
			savedChoices.add(choice);
		}
	return savedChoices;
		
	}

}
