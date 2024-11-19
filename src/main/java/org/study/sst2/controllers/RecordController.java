package org.study.sst2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.study.sst2.models.Record;
import org.study.sst2.services.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public ResponseEntity<List<Record>> getRecords(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Long categoryId) {
        if (userId == null && categoryId == null) {
            return ResponseEntity.badRequest().build();
        }
        if (userId != null) {
            return ResponseEntity.ok(recordService.getRecordsByUserId(userId));
        }
        return ResponseEntity.ok(recordService.getRecordsByCategoryId(categoryId));
    }

    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return recordService.saveRecord(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable Long id) {
        return recordService.getRecordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
