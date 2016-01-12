/**
 * Created by User on 27.10.2015.
 */

import model.Category;
import model.Ingredient;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CreateIT {

    @Test
    public void test() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Spaghetti");
        ingredient.setDescription("Idealses italienisches Nudelgericht");

        Category category = new Category();
        category.setName("Beilage");
        category.setType(1);

        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        ingredient.setCategories(categories);

        EntityManager em = Persistence.createEntityManagerFactory(
                "thecaptains.domain").createEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }
}
