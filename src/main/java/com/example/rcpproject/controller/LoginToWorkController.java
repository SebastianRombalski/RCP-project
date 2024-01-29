package com.example.rcpproject.controller;

import com.example.rcpproject.employee.Employee;
import com.example.rcpproject.employee.EmployeeDTO;
import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class LoginToWorkController {
    private final EventService eventService;
    private final EmployeeService employeeService;

    public LoginToWorkController(EventService eventService, EmployeeService employeeService) {
        this.eventService = eventService;
        this.employeeService = employeeService;
    }

//    @GetMapping("/login")
//    String loginPage(Model model){
//        return "login-logout";
//    }
    @GetMapping("/login")
    String loginPage( String fn, String ln, boolean logout, Model model) {
        if (ln == null) {
            return "login-logout";
        } else {

            if (logout) {
                StringBuilder str = new StringBuilder("logged out " + fn + " " + ln);
                model.addAttribute("info", str);
            } else {
                StringBuilder str = new StringBuilder("logged in " + fn + " " + ln);
                model.addAttribute("info", str);
            }

            return "login-logout";
        }
    }

    @PostMapping("/save")
    String loginToWork(@RequestParam String logincode) {
        EmployeeDTO employeeDTO = employeeService.employeeByLoginCode(logincode).orElse(null);
        if(!(employeeDTO==null)) {
            boolean logout = eventService.addEvent(employeeDTO);
            String firstName = employeeDTO.getFirstName();
            String lastName = employeeDTO.getLastName();
            return UriComponentsBuilder
                    .fromPath("redirect:login")
                    .queryParam("fn", firstName)
                    .queryParam("ln", lastName)
                    .queryParam("logout", logout)
                    .build().toString();
        }
        else return "wrongLoginCode";
    }
}
