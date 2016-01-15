package ch.kitchencaptain;
import ch.kitchencaptain.dto.IngredientDTO;

import java.util.Collection;

/**
 * Created by User on 15.01.2016.
 */
public interface IngredientService {
    public IngredientDTO create(IngredientDTO book);
    public IngredientDTO read(long id);
    public Collection<IngredientDTO> list();
    public IngredientDTO update(IngredientDTO book);
    public void delete(IngredientDTO book);
}
