package ch.kitchencaptain;

import ch.kitchencaptain.dto.CategoryDTO;
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
public class CategoryServiceIT {
    @Inject
    private CategoryService categoryService;

    @Test
    public void test() {

        // Create
        CategoryDTO newCategory = new CategoryDTO();
        newCategory.setTitle("Test");
        newCategory = categoryService.create(newCategory);

        // Read
        CategoryDTO readCategory = categoryService.read(newCategory.getId());
        Assert.assertTrue(newCategory.getTitle().equals(readCategory.getTitle()));

        // Update
        readCategory.setTitle("Test2");
        readCategory = categoryService.update(readCategory);
        CategoryDTO updatedCategory = categoryService.read(readCategory.getId());
        Assert.assertTrue(readCategory.getTitle().equals(updatedCategory.getTitle()));

        // Delete
        categoryService.delete(updatedCategory);
        CategoryDTO deletedCategory = categoryService.read(readCategory.getId());
        Assert.assertNull(deletedCategory);
    }


}
