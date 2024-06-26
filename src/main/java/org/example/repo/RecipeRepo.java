package org.example.repo;

import org.example.model.Recipe;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;


public interface RecipeRepo extends CassandraRepository<Recipe, String> {
    List<Recipe> findAllByUserId(String userId);
}
