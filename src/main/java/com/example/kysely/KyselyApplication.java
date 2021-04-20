package com.example.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.model.Answer;
import com.example.kysely.model.AnswerRepo;
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
	public CommandLineRunner queries(QueryRepo repo, QuestionRepo brepo, AnswerRepo crepo) {
		return (args) -> {
			log.info("save a couple of questions");
			
			
			Query Query1 = new Query("TestQuery"); 
			Query Query2 = new Query("SecondQuery");
			
			repo.save(Query1);   
			repo.save(Query2);
			
			
			log.info("save question");
			Question Question1 = new Question("Käytkö täysipäiväisesti töissä?",Query1); 
			Question Question2 = new Question("Oletko opiskelija?",Query1); 
			Question Question3 = new Question("Pidätkö mansikoista?",Query2); 
			Question Question4 = new Question("Pidätkö mustikoista?",Query2); 
			Question Question5 = new Question("Pidätkö vadelmista?",Query2);
					
			brepo.save(Question1);  
			brepo.save(Question2);  
			brepo.save(Question3);  
			brepo.save(Question4);  
			brepo.save(Question5); 
			
			
			Answer answer1 = new Answer("Käyn töissä", Question1);
			crepo.save(answer1);
			Answer answer2 = new Answer("En ole opiskelija", Question2);
			crepo.save(answer2);
			Answer answer3 = new Answer("Pidän paljon!", Question3);
			crepo.save(answer3); 
			Answer answer4 = new Answer("En tykkää hyi!", Question4);
			crepo.save(answer4); 
			Answer answer5 = new Answer("Joo kyllä", Question5);
			crepo.save(answer5);
			
			
			
			
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
