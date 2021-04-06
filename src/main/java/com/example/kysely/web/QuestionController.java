package com.example.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;

@Controller
public class QuestionController {

@Autowired 
private QuestionRepo repo;  
private QueryRepo queryRepo;

@RequestMapping(value="/questionlist")
public String questionList(Model model) {	
    model.addAttribute("questions", repo.findAll());
    return "questionlist";
}

@RequestMapping(value = "/addQuestion")
public String addQuestion(Model model){
	model.addAttribute("question", new Question());
    return "addQuestion";
}  
 
@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
public String save(Question question){
 repo.save(question);  
 
 
 return "redirect:querylist";
}   
 
@RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.GET)
public String deleteQuestion(@PathVariable("id") Long questionId) {
	repo.deleteById(questionId);
 return "redirect:../questionlist";
}  
}
