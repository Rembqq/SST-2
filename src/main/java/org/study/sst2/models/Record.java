package org.study.sst2.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Record {
    private Long id;
    private Long userId;
    private Long categoryId;
//    private User user;
    private Category category;

    private LocalDateTime creationDateTime;
    private BigDecimal amount;
}
