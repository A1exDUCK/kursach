package org.example.repo;

import org.example.model.Timetable;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;


public interface TimetableRepo extends CassandraRepository<Timetable, UUID> {
    List<Timetable> findAllByUserId(UUID userId);
}
