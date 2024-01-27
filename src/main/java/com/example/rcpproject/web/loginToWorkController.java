package com.example.rcpproject.web;

import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginToWorkController {
    private final EventService eventService;
    private final EmployeeService employeeService;

    public loginToWorkController(EventService eventService, EmployeeService employeeService) {
        this.eventService = eventService;
        this.employeeService = employeeService;
    }

//    @GetMapping("/start")
//    String loginToWork(Model model){
//        eventService.addEvent(employeeService.employeeByLoginCode());
//    }
}
