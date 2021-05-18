package com.example.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.model.Answer;
import com.example.kysely.model.AnswerRepo;
import com.example.kysely.model.Choice;
import com.example.kysely.model.ChoiceRepo;
import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.Question;
import com.example.kysely.model.QuestionRepo;
import com.example.kysely.model.QuestionType;

@SpringBootApplication
public class KyselyApplication { 

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	} 

	@Bean
	public CommandLineRunner queries(QueryRepo repo, QuestionRepo brepo, AnswerRepo crepo, ChoiceRepo drepo) {
		return (args) -> {
			log.info("save a couple of questions");
			
			
			Query Query1 = new Query("Opiskelijakysely"); 
			Query Query2 = new Query("Kesäkysely");
			
			repo.save(Query1);   
			repo.save(Query2);
						
			log.info("save question");
			Question Question1 = new Question(QuestionType.RADIOBUTTON, "Käytkö töissä?",Query1); 
			Question Question2 = new Question(QuestionType.RADIOBUTTON, "Oletko opiskelija?",Query1); 
			Question Question3 = new Question(QuestionType.TEXT, "Pidätkö lomaa?",Query2); 
			Question Question4 = new Question(QuestionType.TEXT,"Menetkö töihin?",Query2); 
			Question Question5 = new Question(QuestionType.TEXT,"Mikä on lempijäätelömaku?",Query2);
			Question Question6 = new Question(QuestionType.TEXT,"Otatko aurinkoa?",Query2);
			Question Question7 = new Question(QuestionType.TEXT,"Käytkö uimassa?",Query2);
					
			brepo.save(Question1);  
			brepo.save(Question2);  
			brepo.save(Question3);  
			brepo.save(Question4);  
			brepo.save(Question5);
			brepo.save(Question6);
			brepo.save(Question7);
			
			Choice choice1 = new Choice("Käyn täysipäiväisesti", Question1);
			Choice choice2 = new Choice("Käyn osa-aikaisesti", Question1);
			Choice choice3 = new Choice("En käy ollenkaan", Question1);
			
			drepo.save(choice1);
			drepo.save(choice2);
			drepo.save(choice3);
			
			Choice choice4 = new Choice("En", Question2);
			Choice choice5 = new Choice("Kyllä", Question2);
			
			drepo.save(choice4);
			drepo.save(choice5);
			
			
			Answer answer1 = new Answer("Käyn täysipäiväisesti", Question1);
			crepo.save(answer1); 
			//log.info(answer1); 
			System.out.println(answer1);
			Answer answer2 = new Answer("En", Question2);
			crepo.save(answer2);
			Answer answer3 = new Answer("Pidän paljon lomaa", Question3);
			crepo.save(answer3); 
			Answer answer4 = new Answer("En!", Question4);
			crepo.save(answer4); 
			Answer answer5 = new Answer("Kaikki käy", Question5);
			crepo.save(answer5);
			Answer answer6 = new Answer("En ota", Question6);
			crepo.save(answer6);
			Answer answer7 = new Answer("Joo paljon!", Question7);
			crepo.save(answer7);
			
			
			
			
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
