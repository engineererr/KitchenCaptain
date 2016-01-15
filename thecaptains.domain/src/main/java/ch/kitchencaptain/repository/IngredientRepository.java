package ch.kitchencaptain.repository;

import ch.kitchencaptain.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 12.01.2016.
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
}