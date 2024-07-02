package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timetable {

    @PrimaryKey
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID userId;
    private String lectorName;
    private String disciplineName;
    private Integer classroom;

    public Timetable(UUID userId, String lectorName, String disciplineName, Integer classroom) {
        this.userId = userId;
        this.lectorName = lectorName;
        this.disciplineName = disciplineName;
        this.classroom = classroom;
    }
}