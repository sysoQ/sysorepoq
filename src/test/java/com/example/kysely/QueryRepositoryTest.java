package com.example.kysely;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.kysely.model.Query;
import com.example.kysely.model.QueryRepo;

//@RunWith(SpringRunner.class)  
@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class QueryRepositoryTest {

    @Autowired
    private QueryRepo repository;

    
    @Test // testing QueryRepository's save()-method
    public void createQuery() {

    	Query query = new Query("Urheilukysely");
    	repository.save(query);
    	assertThat(query.getId()).isNotNull();
    }   
    
    @Test // testing QueryRepository's delete()-method
    public void deleteQuery() {

      List<Query> query = repository.findByName("Marjakysely");
		
		if(query != null) {
			repository.deleteById(query.get(0).getId());
		}
    }



}