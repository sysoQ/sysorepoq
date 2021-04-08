package com.example.kysely;

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
			
			repo.save(query1);  
			
			log.info("fetch all queries");
			for (Query query : repo.findAll()) {
				log.info(query.toString());
			}
					 
			System.out.println("haloo"); 
			
			
			brepo.save(new Question("Käytkö täysipäiväisesti töissä?", 
					repo.findByName("TestQuery").get(0)));
			
			
			/*Question question1 = new Question("Syötkö kasviksia?", query1); 
			brepo.save(question1);*/
			
			

		};
	}

} 
