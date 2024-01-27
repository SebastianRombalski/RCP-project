package com.example.rcpproject.web;



import com.example.rcpproject.event.EventInProgressDTO;
import com.example.rcpproject.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collections;



@Controller
public class activeController {

    private final EventService eventService;

    public activeController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/active")
     String activeEmployee(Model model){


        model.addAttribute("event", eventService.findAllEventInProgress());
        return "active";
    }

}
