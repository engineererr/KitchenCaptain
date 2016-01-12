package repository;

import model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 12.01.2016.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
