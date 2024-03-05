package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
@PostMapping("/editEvent")
    String editEvent(@RequestParam Long id, Model model){
        model.addAttribute("event", eventService.findEventById(id));
        return "editEvent";
}

@PostMapping("/saveEditEvent")
    String saveEditEvent (@RequestParam String startTime, @RequestParam String stopTime, @RequestParam Long id){

        eventService.saveChangedEvent(LocalDateTime.parse(startTime),LocalDateTime.parse(stopTime),id);
        return "redirect:events";
}

@PostMapping("/deleteEvent")
    String deleteEvent(@RequestParam Long id){
        eventService.deleteEvent(id);
        return "redirect:events";
}

@GetMapping("/addEvent")
    String addEvent (String value, Model model){
        if(value != null){
            model.addAttribute("value",value);
        }
        model.addAttribute("employee", employeeService.findEmployees());
        return "addEvent";
}

@PostMapping("saveNewEvent")
        String saveNewEvent(String startTime, String stopTime, Long employeeId){
        if(startTime.isEmpty() || stopTime.isEmpty() || employeeId==0){
            return UriComponentsBuilder
                    .fromPath("redirect:addEvent")
                    .queryParam("value", "wrongData")
                    .build().toString();
        }
        else{
            eventService.saveEvent(startTime, stopTime, employeeService.employeeById(employeeId));
            return "redirect:events";
        }
}





}
