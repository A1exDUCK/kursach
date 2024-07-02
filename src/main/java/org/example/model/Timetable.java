package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    public Timetable(String lectorName, String disciplineName, Integer classroom) {
        this.id = UUID.randomUUID();
        this.userId = UUID.randomUUID();
        this.lectorName = lectorName;
        this.disciplineName = disciplineName;
        this.classroom = classroom;
    }
}