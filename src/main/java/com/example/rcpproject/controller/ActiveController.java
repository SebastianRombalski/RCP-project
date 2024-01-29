package com.example.rcpproject.controller;



import com.example.rcpproject.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ActiveController {

    private final EventService eventService;

    public ActiveController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/active")
     String activeEmployee(Model model){


        model.addAttribute("event", eventService.findAllEventInProgress());
        return "active";
    }

}
