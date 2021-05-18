package com.example.kysely.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;



@Controller
public class QuestionController {

@Autowired 
private QuestionRepo repo;   

@Autowired 
private QueryRepo queryRepo; 


@RequestMapping(value="/questionlist")
public String questionList(Model model) {	
    model.addAttribute("questions", repo.findAll());
    return "questionlist";
} 

@RequestMapping(value="/addQuestion")
public String addQuestion(Model model) {	
    model.addAttribute("question", new Question()); 
    model.addAttribute("query", queryRepo.findAll()); 
    return "addquestion";
}


@RequestMapping(value = "/querylist/{id}/questionlist/addQuestion", method = RequestMethod.GET)
public String addQuestionToQuery(@PathVariable("id") Long id, Model model){
	
	Optional<Query> queryOptional = queryRepo.findById(id);

    Query query = queryOptional.get(); 

    Long queryId = query.getId();


    model.addAttribute("thisquery", query);
    model.addAttribute("thisqueryId", queryId);
    model.addAttribute("question", new Question(query)); 
    model.addAttribute("questions", repo.findAll()); 
    model.addAttribute("queries", queryRepo.findAll());
   
    return "addquestion";
}   

@RequestMapping(value= "/questionlistbyquery/{id}", method = RequestMethod.GET)
public String questionListByQuery(@PathVariable("id") Long queryId, Model model) {	
	
	
	
	Optional<Query> queryOptional = queryRepo.findById(queryId);

    Query query = queryOptional.get(); 
	
	
     List<Question> kyssarit = (List<Question>) repo.findAll();   
     List<Question> valitutKyssarit = new ArrayList<>();
     
     for(int i = 0; i < kyssarit.size(); i++) { 
    	 System.out.println("tahan menin");
    	 if(kyssarit.get(i).getQuery().equals(query)) { 
    		valitutKyssarit.add(kyssarit.get(i)); 
    	 }  
     }
     model.addAttribute("questions", valitutKyssarit); 
    return "questionlist";
}   
 
@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
public String save(Question question){ 
		repo.save(question);
		return "redirect:questionlistbyquery/" + question.getQuery().getId();
}    



} 
