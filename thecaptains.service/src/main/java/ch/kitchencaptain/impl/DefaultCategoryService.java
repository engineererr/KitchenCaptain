package ch.kitchencaptain.impl;

import ch.kitchencaptain.CategoryService;
import ch.kitchencaptain.dto.CategoryDTO;
import ch.kitchencaptain.model.Category;
import ch.kitchencaptain.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by User on 15.01.2016.
 */
@Named
public class DefaultCategoryService implements CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    private final ModelMapper mapper = new ModelMapper();

    public CategoryDTO create(CategoryDTO categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category persistedCategory = categoryRepository.save(category);
        return mapper.map(persistedCategory, CategoryDTO.class);
    }

    public CategoryDTO read(long id) {
        Category category = categoryRepository.findOne(id);
        if (category == null) return null;
        return mapper.map(category, CategoryDTO.class);
    }

    public Collection<CategoryDTO> list() {
        Iterable<Category> categorys = categoryRepository.findAll();
        Type listType = new TypeToken<Collection<CategoryDTO>>() {
        }.getType();
        return mapper.map(categorys, listType);
    }

    public CategoryDTO update(CategoryDTO categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        Category updatedCategory = categoryRepository.save(category);
        return mapper.map(updatedCategory, CategoryDTO.class);
    }

    public void delete(CategoryDTO categoryDto) {
        Category category = categoryRepository.findOne(categoryDto.getId());
        categoryRepository.delete(category);
    }
}
