package ch.kitchencaptain.model; /**
 * 
 */

import ch.kitchencaptain.model.Ingredient;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rovi
 * 
 */
public class ReadIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"thecaptains.domain").createEntityManager();

		Query q = em.createQuery("select a from Ingredient a");
		@SuppressWarnings("unchecked")
		List<Ingredient> foundIngredients = q.getResultList();
		Ingredient firstIngredient = foundIngredients.get(0);
		Assert.assertTrue(firstIngredient.getTitle().equals("Spaghetti"));

	}

}
