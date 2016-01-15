package model; /**
 * 
 */

import model.Ingredient;
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
public class UpdateIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"thecaptains.domain").createEntityManager();

		Query q = em.createQuery("select a from Ingredient a");
		@SuppressWarnings("unchecked")
		List<Ingredient> foundIngredients = q.getResultList();
		Ingredient firstIngredient = foundIngredients.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstIngredient.setName("Penne");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstIngredient.getName().equals("Penne"));
	}

}
