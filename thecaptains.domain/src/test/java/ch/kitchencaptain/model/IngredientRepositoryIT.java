package ch.kitchencaptain.model; /**
 * Created by User on 27.10.2015.
 */
import ch.kitchencaptain.repository.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class IngredientRepositoryIT {
    @Inject
    private IngredientRepository ingredientRepository;

    @Test
    public void test() {
        // Create
        Ingredient newIngredient = new Ingredient();
        newIngredient.setTitle("Test");
        ingredientRepository.save(newIngredient);

        // Read
        Ingredient readIngredient = ingredientRepository.findOne(newIngredient.getId());
        org.junit.Assert.assertTrue(newIngredient.getTitle().equals(readIngredient.getTitle()));

        // Update
        readIngredient.setTitle("Test2");
        readIngredient = ingredientRepository.save(readIngredient);
        Ingredient updatedBook = ingredientRepository.findOne(readIngredient.getId());
        org.junit.Assert.assertTrue(readIngredient.getTitle().equals(updatedBook.getTitle()));
        // Delete
        ingredientRepository.delete(updatedBook);
        Ingredient deletedBook = ingredientRepository.findOne(readIngredient.getId());
        org.junit.Assert.assertNull(deletedBook);
    }
}
