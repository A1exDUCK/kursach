package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recipe {
    @Id
    private String id;
    private String name;
    private String ingredients;
    private String userId;
}
