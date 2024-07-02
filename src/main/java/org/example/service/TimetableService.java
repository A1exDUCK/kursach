package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Timetable;
import org.example.repo.TimetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
public class TimetableService {
    @Autowired
    private TimetableRepo timetableRepo;

    public List<Timetable> findAllByUserId(String userId) {
        UUID uuid;
        try {
            uuid = UUID.fromString(userId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID string: " + userId, e);
        }
        log.info("Show all timetables for user: {}", userId);
        return timetableRepo.findAllByUserId(UUID.fromString(userId));
    }

    public Timetable findById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID string: " + id, e);
        }
        return timetableRepo.findById(UUID.fromString(id)).orElseThrow(() -> new NoSuchElementException("Timetable not found"));
    }

    public void addTimetable(Timetable timetable) {
        Timetable result = timetableRepo.save(timetable);
        log.info("Added a new timetable: {}", result);
    }

    public void deleteById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID string: " + id, e);
        }
        log.info("Removed timetable by id: {}", id);
        timetableRepo.deleteById(UUID.fromString(id));
    }
}
