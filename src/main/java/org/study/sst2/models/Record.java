package org.study.sst2.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private final Long userId;
//    private final Long categoryId;
    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private LocalDateTime creationDateTime;
    private BigDecimal amount;
}
