package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeDTO;
import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.section.SectionDTO;
import com.example.rcpproject.section.SectionService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final SectionService sectionService;

    public EmployeeController(EmployeeService employeeService, SectionService sectionService) {
        this.employeeService = employeeService;
        this.sectionService = sectionService;
    }

    @GetMapping("/employee")
    String employee(Long sectionId, Model model){
        List<SectionDTO> sectionList = sectionService.findSections();
        model.addAttribute("sectionList", sectionList);
        if (sectionId!=null && sectionId!=0) {
            model.addAttribute("employee", employeeService.employeesBySection(sectionId));
            return "employee";
        }
        else {
            model.addAttribute("employee", employeeService.findEmployees());
            return "employee";
        }
    }

    @GetMapping("/filter")
    String filterEmployeeBySection(@RequestParam Long sectionId){
        return UriComponentsBuilder
                .fromPath("redirect:employee")
                .queryParam("sectionId", sectionId)
                .build().toString();

    }


    @PostMapping("/changeStatus")
    String changeStatus(@RequestParam Long employeeId){
        employeeService.changeStatus(employeeId);

        return "redirect:employee";
    }

    @GetMapping("/employee/add")
    String add( Model model){
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("listSection", sectionService.findSections());
        return "addEmployee";
    }


    @PostMapping("/employee/saveNewEmployee")
    String addEmployee(@Valid @ModelAttribute("employee")EmployeeDTO employeeDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors() || employeeService.checkLoginCode(employeeDTO.getLoginCode())){
            model.addAttribute("listSection", sectionService.findSections());
            if(employeeService.checkLoginCode(employeeDTO.getLoginCode())){
                model.addAttribute("loginCode", "This code is already used");
            }
        return "addEmployee";

        }
        else {
            employeeService.saveEmployee(employeeDTO);
            return UriComponentsBuilder
                    .fromPath("redirect:/employee")
                    .queryParam("sectionId", employeeDTO.getSection().getId())
                    .build().toString();
        }
    }
    @GetMapping("/employee/edit")
    String editEmployee(@RequestParam Long employeeId, Model model){
        model.addAttribute("employee",employeeService.employeeById(employeeId));
        model.addAttribute("listSection", sectionService.findSections());

        return "editEmployee";
    }

    @PostMapping("/saveEditEmployee")
    String saveEditEmployee(@Valid @ModelAttribute("employee")EmployeeDTO employeeDTO, BindingResult bindingResult, Model model){
employeeService.saveEmployee(employeeDTO);
        return UriComponentsBuilder
                .fromPath("redirect:employee")
                .queryParam("id", employeeDTO.getSection().getId())
                .build().toString();
    }

//    @PostMapping("/saveEditEmployee")
//    String saveEditEmployee(@RequestParam Long id,
//                            @RequestParam String firstName,
//                            @RequestParam String lastName,
//                            @RequestParam String loginCode,
//                            @RequestParam Long sectionId){
//        EmployeeDTO employeeDTO = employeeService.employeeById(id);
//        employeeDTO.setSection(sectionService.findSectionById(sectionId));
//        employeeDTO.setFirstName(firstName);
//        employeeDTO.setLastName(lastName);
//        employeeDTO.setLoginCode(loginCode);
//        employeeService.saveEmployee(employeeDTO);
//        return UriComponentsBuilder
//                .fromPath("redirect:employee")
//                .queryParam("id", sectionId)
//                .build().toString();
//    }

}
