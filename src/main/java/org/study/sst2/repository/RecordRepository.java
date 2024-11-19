package org.study.sst2.repository;

import org.study.sst2.models.Record;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class RecordRepository {
    private final Map<Long, Record> records = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Record> findAll() {
        return new ArrayList<>(records.values());
    }

    public Optional<Record> findById(Long id) {
        return Optional.ofNullable(records.get(id));
    }

    public List<Record> findByUserId(Long userId) {
        return records.values().stream()
                .filter(record -> record.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Record> findByCategoryId(Long categoryId) {
        return records.values().stream()
                .filter(record -> record.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    public Record save(Record record) {
        if (record.getId() == null) {
            record.setId(idGenerator.getAndIncrement());
        }
        records.put(record.getId(), record);
        return record;
    }

    public void deleteById(Long id) {
        records.remove(id);
    }
}

