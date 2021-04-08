package com.example.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;




@Controller
public class QueryController { 
	@Autowired
	private QueryRepo repo;  
	private QuestionRepo questionRepo;
	

	 @RequestMapping(value= "/querylist")
	    public String queryList(Model model) {	
	        model.addAttribute("queryList", repo.findAll());
	        return "querylist";
	    }  
	 
	/* @RequestMapping(value="/queries", method = RequestMethod.GET) 
	 public @ResponseBody List<Query> queryListRest(){ 
		 return (List<Query>)repo.findAll();
	 }  */

     @RequestMapping(value= {"/addQuery"})
	    public String addQuery(Model model) {	
    	 	model.addAttribute("query", new Query());  	
	        return "addQuery";
	    } 
	 
	 @RequestMapping(value = "/saveQuery", method = RequestMethod.POST)
	    public String saveQuery(Query query){
	        repo.save(query); 
	        System.out.println(query);
	        return "redirect:querylist";
	    }     
	 
	 @RequestMapping(value = "/query/{id}/addquestions", method = RequestMethod.GET)
	    public String addQuestionsToQuery(@PathVariable("id") Long id, Model model) {

	        Optional<Query> queryOptional = repo.findById(id);

	        Query query = queryOptional.get(); // Getting rid of the Optional Wrapper.

	        Long queryId = query.getId();


	        model.addAttribute("thisquery", query);
	        model.addAttribute("thissurveyId", id);
	        model.addAttribute("question", new Question(query)); // A question with a pre-determined Survey values. Adding two more values. Arttu K, 28.04.2020.
	        model.addAttribute("questions", questionRepo.findAll());
	        return "addquestionstosurvey";
	    }


	    //REST for Surveys.

	    @CrossOrigin
	    @RequestMapping(value = "/querieslist", method = RequestMethod.GET)
	    public @ResponseBody
	    List<Query> queries() {
	        return (List<Query>) repo.findAll();
	    }

	    @CrossOrigin
	    @RequestMapping(value = "/querieslist/{id}", method = RequestMethod.GET)
	    // CrossOrigin for requests from another service, no parameters needed now 
	    public @ResponseBody
	    Optional<Query> queriesById(@PathVariable Long id) {
	        return repo.findById(id);
	    }
	}
	 
	
	 
	 
