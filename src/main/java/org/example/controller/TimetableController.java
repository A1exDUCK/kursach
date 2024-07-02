package org.example.controller;

import org.example.model.Timetable;
import org.example.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping("/")
    private String getMain() {
        return "redirect:/login";
    }

    @GetMapping("/timetables/{userId}")
    private String getTimetables(Model model, @PathVariable("userId") String userId) {
        List<Timetable> timetables = timetableService.findAllByUserId(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("timetables", timetables);
        return "timetables";
    }

    @GetMapping("/add/{userId}")
    private String getAdd(Model model, @PathVariable("userId") String userId) {
        model.addAttribute("userId", userId);
        return "add";
    }

    @PostMapping("/add")
    private String postAdd(Timetable timetable) {
        timetableService.addTimetable(timetable);
        return "redirect:/timetables/" + timetable.getUserId();
    }

    @PostMapping("/delete/{userId}")
    private String postDelete(Model model, String id, @PathVariable("userId") String userId) {
        timetableService.deleteById(id);
        return getTimetables(model, userId);
    }
}
