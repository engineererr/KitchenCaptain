package model; /**
 * Created by User on 27.10.2015.
 */

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CreateIT {

    @Test
    public void test() {
        Category category = new Category();
        category.setName("Beilage");

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Spaghetti");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Speck");

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingredient);
        ingredients.add(ingredient2);

        category.setIngredients(ingredients);

        ingredient.setCategory(category);
        ingredient2.setCategory(category);

        EntityManager em = Persistence.createEntityManagerFactory(
                "thecaptains.domain").createEntityManager();

        em.getTransaction().begin();
        em.persist(ingredient);
        em.getTransaction().commit();

    }
}
