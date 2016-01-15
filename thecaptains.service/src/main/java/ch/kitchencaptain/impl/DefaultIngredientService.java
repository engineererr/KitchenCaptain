package ch.kitchencaptain.impl;

import ch.kitchencaptain.IngredientService;
import ch.kitchencaptain.dto.IngredientDTO;
import ch.kitchencaptain.model.Ingredient;
import ch.kitchencaptain.repository.IngredientRepository;
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
public class DefaultIngredientService implements IngredientService {
    @Inject
    private IngredientRepository ingredientRepository;

    private final ModelMapper mapper = new ModelMapper();

    public IngredientDTO create(IngredientDTO ingredientDto) {
        Ingredient ingredient = mapper.map(ingredientDto, Ingredient.class);
        Ingredient persistedIngredient = ingredientRepository.save(ingredient);
        return mapper.map(persistedIngredient, IngredientDTO.class);
    }

    public IngredientDTO read(long id) {
        Ingredient ingredient = ingredientRepository.findOne(id);
        if (ingredient == null) return null;
        return mapper.map(ingredient, IngredientDTO.class);
    }

    public Collection<IngredientDTO> list() {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type listType = new TypeToken<Collection<IngredientDTO>>() {
        }.getType();
        return mapper.map(ingredients, listType);
    }

    public IngredientDTO update(IngredientDTO ingredientDto) {
        Ingredient ingredient = mapper.map(ingredientDto, Ingredient.class);
        Ingredient updatedIngredient = ingredientRepository.save(ingredient);
        return mapper.map(updatedIngredient, IngredientDTO.class);
    }

    public void delete(IngredientDTO ingredientDto) {
        Ingredient ingredient = ingredientRepository.findOne(ingredientDto.getId());
        ingredientRepository.delete(ingredient);
    }
}
