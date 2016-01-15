package ch.kitchencaptain;

import ch.kitchencaptain.dto.IngredientDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by User on 15.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class IngredientServiceIT {

    @Inject
    private IngredientService ingredientService;

    @Test
    public void test() {

        // Create
        IngredientDTO newIngredient = new IngredientDTO();
        newIngredient.setName("Test");
        newIngredient = ingredientService.create(newIngredient);

        // Read
        IngredientDTO readIngredient = ingredientService.read(newIngredient.getId());
        Assert.assertTrue(newIngredient.getName().equals(readIngredient.getName()));

        // Update
        readIngredient.setName("Test2");
        readIngredient = ingredientService.update(readIngredient);
        IngredientDTO updatedIngredient = ingredientService.read(readIngredient.getId());
        Assert.assertTrue(readIngredient.getName().equals(updatedIngredient.getName()));

        // Delete
        ingredientService.delete(updatedIngredient);
        IngredientDTO deletedIngredient = ingredientService.read(readIngredient.getId());
        Assert.assertNull(deletedIngredient);
    }
}
