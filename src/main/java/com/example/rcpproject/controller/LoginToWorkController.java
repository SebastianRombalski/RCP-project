package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeDTO;
import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
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


    @GetMapping("/")
    String loginPage(String status, String fn, String ln, boolean logout, Model model) {
        if (status == null) {
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
        } else if(status.equals("false")) {
            String str = "this account is inactive";
            model.addAttribute("info", str);
            return "login-logout";
        }
        else if(status.equals("wrongLoginCode")){
            String str = "Wrong login code";
            model.addAttribute("info", str);
            return "login-logout";
        }
        else return "somethingWentsWrong";
    }

    @PostMapping("/sendLoginLogout")
    String loginToWork(@RequestParam String logincode) {
        EmployeeDTO employeeDTO = employeeService.employeeByLoginCode(logincode).orElse(null);
        if (!(employeeDTO == null)) {
            if (employeeDTO.getStatus().equals("active")) {
                boolean logout = eventService.addEvent(employeeDTO);
                String firstName = employeeDTO.getFirstName();
                String lastName = employeeDTO.getLastName();
                return UriComponentsBuilder
                        .fromPath("redirect:/")
                        .queryParam("fn", firstName)
                        .queryParam("ln", lastName)
                        .queryParam("logout", logout)
                        .build().toString();
            } else return UriComponentsBuilder
                    .fromPath("redirect:/")
                    .queryParam("status", "false")
                    .build().toString();

        } else return UriComponentsBuilder
                .fromPath("redirect:/")
                .queryParam("status", "wrongLoginCode")
                .build().toString();

    }
}
