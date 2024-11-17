package org.study.sst2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.sst2.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
