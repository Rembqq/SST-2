package org.study.sst2.repository;

import org.study.sst2.models.Category;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoryRepository {
    private final Map<Long, Category> categories = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(categories.get(id));
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(idGenerator.getAndIncrement());
        }
        categories.put(category.getId(), category);
        return category;
    }

    public void deleteById(Long id) {
        categories.remove(id);
    }
}

