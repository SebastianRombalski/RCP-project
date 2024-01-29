package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeDTO;
import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.section.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final SectionService sectionService;

    public EmployeeController(EmployeeService employeeService, SectionService sectionService) {
        this.employeeService = employeeService;
        this.sectionService = sectionService;
    }

    @GetMapping("/employee")
    String employee(String description, Integer shift, Model model){
        if (description!=null) {
            Long id = sectionService.findSection(description, shift).getId();
            model.addAttribute("employee", employeeService.employeesBySection(id));
            return "employee";
        }
        else return "employee";
    }

    @PostMapping("/search")
    String searchEmployee(@RequestParam String decsription, @RequestParam Integer shift){
        return UriComponentsBuilder
                .fromPath("redirect:employee")
                .queryParam("description", decsription)
                .queryParam("shift", shift)
                .build().toString();

    }
}
