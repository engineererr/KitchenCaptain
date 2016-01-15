package ch.kitchencaptain.rest.controller;

import ch.kitchencaptain.IngredientService;
import ch.kitchencaptain.dto.IngredientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/ingredients")
public class IngredientController {

	@Inject
	private IngredientService ingredientService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public IngredientDTO createIngredient(@RequestBody IngredientDTO ingredient) {
		IngredientDTO createdIngredient = ingredientService.create(ingredient);
		System.out.println("Ingredient created with id = " + createdIngredient.getId());
		return createdIngredient;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<IngredientDTO> getIngredients() {
		System.out.println("Collection of Ingredient requested");
		return ingredientService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public IngredientDTO getIngredient(@PathVariable long id) {
		System.out.println("Ingredient requested with id = " + id);
		return ingredientService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public IngredientDTO updateIngredient(@RequestBody IngredientDTO ingredient) {
		IngredientDTO updatedIngredient = ingredientService.update(ingredient);
		System.out.println("Ingredient updated with id = " + updatedIngredient.getId());
		return updatedIngredient;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteIngredient(@PathVariable long id) {
		IngredientDTO ingredient = ingredientService.read(id);
		ingredientService.delete(ingredient);
		System.out.println("Delete Ingredient with id = " + id);
	}
}
