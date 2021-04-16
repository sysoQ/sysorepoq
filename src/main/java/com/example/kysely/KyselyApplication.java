package com.example.kysely;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;

@SpringBootApplication
public class KyselyApplication { 

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	} 

	@Bean
	public CommandLineRunner queries(QueryRepo repo, QuestionRepo brepo) {
		return (args) -> {
			log.info("save a couple of questions");
			
			
			Query query1 = new Query("TestQuery"); 
			Query query2 = new Query("SecondQuery");
			
			repo.save(query1);   
			repo.save(query2);
			
			
			log.info("save question");
			//Question Question1 = new Question("Käytkö täysipäiväisesti töissä?", query1);
					
			brepo.save(new Question("Käytkö täysipäiväisesti töissä?", 
					repo.findByName("TestQuery").get(0)));  
			brepo.save(new Question("Oletko opiskelija?", 
					repo.findByName("TestQuery").get(0)));  
			brepo.save(new Question("Pidätkö mansikoista?", 
					repo.findByName("SecondQuery").get(0)));  
			brepo.save(new Question("Pidätkö mustikoista?", 
					repo.findByName("SecondQuery").get(0)));  
			brepo.save(new Question("Pidätkö vadelmista?", 
					repo.findByName("SecondQuery").get(0))); 
			
			/*List<Question> questions = new ArrayList<Question>(); 
			questions.add(Question1); 
			query1.setQuestionList(questions);
			System.out.println(query1.getQuestionList());*/ 
			
			
			
			log.info("fetch all queries");
			for (Question question : brepo.findAll()) {
				log.info(question.toString());
			}
			
			
			/*Question question1 = new Question("Syötkö kasviksia?", query1); 
			brepo.save(question1);*/
			
			

		};
	}

} 
