package org.study.sst2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.study.sst2.models.Record;
import org.study.sst2.repository.RecordRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordRepository recordRepository;

    public RecordController(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @GetMapping
    public ResponseEntity<List<Record>> getRecordByUserOrCategory
            (@RequestParam(required = false) Long userId,
             @RequestParam(required = false) Long categoryId) {;
        if(userId != null && categoryId != null) {
            return ResponseEntity.ok(recordRepository.findByUserIdAndCategoryId(userId, categoryId));
        } else if(userId != null) {
            return ResponseEntity.ok(recordRepository.findByUserId(userId));
        } else if(categoryId != null) {
            return ResponseEntity.ok(recordRepository.findByCategoryId(categoryId));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        return recordRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        record.setCreationDateTime(LocalDateTime.now());
        return ResponseEntity.ok(recordRepository.save(record));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@PathVariable Long id) {
        if(recordRepository.existsById(id)) {
            recordRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
