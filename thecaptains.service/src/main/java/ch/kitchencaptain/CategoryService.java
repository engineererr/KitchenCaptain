package ch.kitchencaptain;
import ch.kitchencaptain.dto.CategoryDTO;

import java.util.Collection;

/**
 * Created by User on 15.01.2016.
 */
public interface CategoryService {
    public CategoryDTO create(CategoryDTO book);
    public CategoryDTO read(long id);
    public Collection<CategoryDTO> list();
    public CategoryDTO update(CategoryDTO book);
    public void delete(CategoryDTO book);
}
