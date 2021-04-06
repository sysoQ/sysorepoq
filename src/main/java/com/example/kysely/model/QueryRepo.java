package com.example.kysely.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QueryRepo extends CrudRepository<Query, Long> { 
   // List<Query> findById(String id);

}