package io.keepcoding.data;

import org.springframework.data.repository.CrudRepository;

import io.keepcoding.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
