package pl.pjatk.jaz.category;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO
{
    List<CategoryEntity> getCategoryList();
    Optional<CategoryEntity> getCategoryById(Long categoryId);
    void save(CategoryEntity categoryEntity);
    void delete(CategoryEntity categoryEntity);
}
