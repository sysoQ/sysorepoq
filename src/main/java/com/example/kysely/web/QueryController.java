package com.example.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.QuestionRepo;




@Controller
public class QueryController { 
	@Autowired
<<<<<<< HEAD
	private QueryRepo repo; 
	
	//@Autowired
	//private QuestionRepo questionRepo;
=======
	private QueryRepo repo;  
>>>>>>> d39dc241500e7703f486aaf91039700479c5c052
	

	 @RequestMapping(value= "/querylist")
	    public String queryList(Model model) {	
	        model.addAttribute("queries", repo.findAll());
	        return "querylist";
	    }   
	 

     @RequestMapping(value= {"/addQuery"})
	    public String addQuery(Model model) {	
    	 	model.addAttribute("query", new Query());  	
	        return "addQuery";
	    } 
	 
	 @RequestMapping(value = "/saveQuery", method = RequestMethod.POST)
	    public String saveQuery(Query query){
	        repo.save(query); 
	        System.out.println(repo.findAll());
	        return "redirect:querylist";
	    }     
	 

		@CrossOrigin
		@RequestMapping(value="/queries", method = RequestMethod.GET) 
		 public @ResponseBody List<Query> queryListRest(){ 
			 return (List<Query>)repo.findAll();
		 }  
	 
	}
	 
	
	 
	 
