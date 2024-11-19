package org.study.sst2.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
}
