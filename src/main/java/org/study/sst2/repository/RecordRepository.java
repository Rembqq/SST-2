package org.study.sst2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.sst2.models.Record;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserId(Long userId);

    List<Record> findByCategoryId(Long categoryId);

    List<Record> findByUserIdAndCategoryId(Long userId, Long categoryId);
}

