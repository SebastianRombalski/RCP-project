package com.example.rcpproject.controller;

import com.example.rcpproject.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    String event(Model model){
        model.addAttribute("event",eventService.findAllEvent());
        return "events";
    }
}
