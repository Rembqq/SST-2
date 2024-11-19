package org.study.sst2.services;

import org.springframework.stereotype.Service;
import org.study.sst2.models.Record;
import org.study.sst2.repository.RecordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Optional<Record> getRecordById(Long id) {
        return recordRepository.findById(id);
    }

    public List<Record> getRecordsByUserId(Long userId) {
        return recordRepository.findByUserId(userId);
    }

    public List<Record> getRecordsByCategoryId(Long categoryId) {
        return recordRepository.findByCategoryId(categoryId);
    }

    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }
}