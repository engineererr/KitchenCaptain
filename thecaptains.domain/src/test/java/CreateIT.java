/**
 * Created by User on 27.10.2015.
 */
import model.Category;
import model.Ingredient;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CreateIT {

    @Test
    public void test() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Spaghetti");
        ingredient.setDescription("Idealses italienisches Nudelgericht");

        Category category = new Category();
        category.setName("Beilage");
        category.setType(1);

        ingredient.setCategoryId(category);

        EntityManager em = Persistence.createEntityManagerFactory(
                "thecaptains.domain").createEntityManager();

        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }
}
