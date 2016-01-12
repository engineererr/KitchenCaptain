/**
 * Created by User on 27.10.2015.
 */
import model.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.IngredientRepository;

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
        newIngredient.setName("Test");
        ingredientRepository.save(newIngredient);

        // Read
        Ingredient readIngredient = ingredientRepository.findOne(newIngredient.getId());
        org.junit.Assert.assertTrue(newIngredient.getName().equals(readIngredient.getName()));

        // Update
        readIngredient.setName("Test2");
        readIngredient = ingredientRepository.save(readIngredient);
        Ingredient updatedBook = ingredientRepository.findOne(readIngredient.getId());
        org.junit.Assert.assertTrue(readIngredient.getName().equals(updatedBook.getName()));
        // Delete
        ingredientRepository.delete(updatedBook);
        Ingredient deletedBook = ingredientRepository.findOne(readIngredient.getId());
        org.junit.Assert.assertNull(deletedBook);
    }
}
