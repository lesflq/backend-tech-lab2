package uk.sevastianov.lab2.Service;

import org.springframework.stereotype.Service;
import uk.sevastianov.lab2.Entity.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private Map<Long, Category> categories = new HashMap<>();
    private long nextId = 1L;

    public Category createCategory(Category category) {
        category.toBuilder().id(nextId++).build();
        categories.put(category.getId(), category);
        return category;
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public boolean deleteCategory(Long id) {
        return categories.remove(id) != null;
    }
}
