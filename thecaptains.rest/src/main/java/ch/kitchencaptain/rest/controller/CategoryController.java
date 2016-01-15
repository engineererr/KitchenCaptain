package ch.kitchencaptain.rest.controller;

import ch.kitchencaptain.CategoryService;
import ch.kitchencaptain.dto.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;


@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Inject
	private CategoryService categoryService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
		CategoryDTO createdCategory = categoryService.create(category);
		System.out.println("Category created with id = " + createdCategory.getId());
		return createdCategory;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<CategoryDTO> getCategorys() {
		System.out.println("Collection of Category requested");
		return categoryService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public CategoryDTO getCategory(@PathVariable long id) {
		System.out.println("Category requested with id = " + id);
		return categoryService.read(id);
	}

	/**
	 * Update
	 */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CategoryDTO update(@RequestBody CategoryDTO category, @PathVariable long id) {
		CategoryDTO updatedCategory = categoryService.update(category);
		System.out.println("Category updated with id = " + updatedCategory.getId());
		return updatedCategory;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable long id) {
		CategoryDTO category = categoryService.read(id);
		categoryService.delete(category);
		System.out.println("Delete Category with id = " + id);
	}
}
