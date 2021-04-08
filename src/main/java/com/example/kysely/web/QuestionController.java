package com.example.kysely.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kysely.model.Query;
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
	model.addAttribute("queries", queryRepo.findAll());
    return "addQuestion";
}  
 
@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
public String save(Question question){ 
	repo.save(question);
	
	
	/*Query lastQuery = queries().get(queries().size() - 1);
	
	lastQuery.setQuestion(question); 
	System.out.println(query);
	queryRepo.save(query);  

 /*queryRepo.findAll().get(queryRepo.count()); 
 //List<Person> persons = repository.findByLastname("Matthews");
 Optional<Query> allQueries = queryRepo.findById(queryRepo.count() - 1);
 queryRepo.findAll(); 
 for (Query query : queryRepo.findAll()) {
		;
	}*/
 
 return "redirect:querylist";
}    

/*@CrossOrigin
@RequestMapping(value = "/queries", method = RequestMethod.GET) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
public List<Query> queries() {
    return (List<Query>) queryRepo.findAll();
}

 
@RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.GET)
public String deleteQuestion(@PathVariable("id") Long questionId) {
	repo.deleteById(questionId);
 return "redirect:../questionlist";
}  */ 

@CrossOrigin
@RequestMapping(value = "/questions", method = RequestMethod.GET) 
public @ResponseBody List<Question> questions() {
    return (List<Question>) repo.findAll();
}

 //RESTful service to get one product by id.
	@CrossOrigin
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional <Question> findQuestionRest(@PathVariable Long id) { 
		return repo.findById(id); 
	}
	
	
@CrossOrigin
@RequestMapping(value = "/questions", method = RequestMethod.POST) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
public @ResponseBody Question saveQuestionRest(@RequestBody Question question ) {
	return repo.save(question);
}

// Home page of REST services, Template created with examples, no need for @CrossOrigin
@RequestMapping(value="/resthome", method = RequestMethod.GET)
public String getRestHome() {	
	return "resthome"; // resthome.html, oma tiedosto, ei tule importtien kautta. - Arttu Kesanto 09.04.2020.
}
} 
