package model; /**
 * 
 */

import model.Ingredient;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author rovi
 * 
 */
public class DeleteIT {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"thecaptains.domain").createEntityManager();

		Query q = em.createQuery("select a from Ingredient a");
		@SuppressWarnings("unchecked")
		List<Ingredient> foundIngredients = q.getResultList();
		Ingredient firstAuthor = foundIngredients.get(0);
		// Assert.assertTrue(firstAuthor.getLastname().equals("Tolkien"));

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstAuthor);
		em.getTransaction().commit();
	}

}
