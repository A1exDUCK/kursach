package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Timetable {
    @PrimaryKey
    private UUID id;
    private UUID userId;
    private String lectorName;
    private String disciplineName;
    private Integer classroom;
}
