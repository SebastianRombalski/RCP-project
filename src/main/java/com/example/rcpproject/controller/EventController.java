package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class EventController {

    private final EventService eventService;
    private final EmployeeService employeeService;

    public EventController(EventService eventService, EmployeeService employeeService) {
        this.eventService = eventService;
        this.employeeService = employeeService;
    }

    @GetMapping("/events")
    String event(String fromDate, String toDate, Long id, Model model){
        if(fromDate==null && toDate==null&& id==null) {
            model.addAttribute("event", eventService.findAllEvent());
            model.addAttribute("employees", employeeService.findEmployees());
            return "events";
        }

        else {
            model.addAttribute("event", eventService.findEventByEmployeeBetweenDate(id,fromDate,toDate));
            model.addAttribute("employees", employeeService.findEmployees());
            model.addAttribute("fromDate", fromDate);
            model.addAttribute("toDate",toDate);
            model.addAttribute("employee", employeeService.employeeById(id));
            return "events";
        }
    }

    @PostMapping("/filterEvents")
    String filterEvents(String fromDate, String toDate, Long employeeID){
            return UriComponentsBuilder
                    .fromPath("redirect:events")
                    .queryParam("fromDate", fromDate)
                    .queryParam("toDate", toDate)
                    .queryParam("id", employeeID)
                    .build().toString();
    }






}
