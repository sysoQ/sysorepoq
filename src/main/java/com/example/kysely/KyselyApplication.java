package com.example.kysely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean; 

import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;
import com.example.kysely.model.QuestionRepo;  
import com.example.kysely.model.Question;

@SpringBootApplication
public class KyselyApplication { 

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	} 

	@Bean
	public CommandLineRunner queries(QueryRepo repo) {
		return (args) -> {
			log.info("save a couple of questions");
			
			Question question1 = new Question("Syötkö kasviksia?");
			
			repo.save(new Query("TestQuery", question1)); 
					
			
			log.info("fetch all questions");
			for (Query query : repo.findAll()) {
				log.info(query.toString());
			}

		};
	}

} 
