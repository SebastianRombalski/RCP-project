package com.example.rcpproject.controller;

import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.manager.ManagerService;
import com.example.rcpproject.section.Section;
import com.example.rcpproject.section.SectionDTO;
import com.example.rcpproject.section.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class SectionController {
    private final SectionService sectionService;
    private final EmployeeService employeeService;

    private final ManagerService managerService;

    public SectionController(SectionService sectionService, EmployeeService employeeService, ManagerService managerService) {
        this.sectionService = sectionService;
        this.employeeService = employeeService;
        this.managerService = managerService;
    }

    @GetMapping("/section")
    String section(String value, Model model){
        if(value != null){
            model.addAttribute("value", value);
        }
        model.addAttribute("sections", sectionService.findSections());
        return "section";
    }

    @GetMapping("/editSection")
    String editSection(@RequestParam Long id, Model model){
        model.addAttribute("section", sectionService.findSectionDTOById(id));
        return "editSection";
    }

    @PostMapping("/saveEditSection")
    String saveEditSection (@RequestParam String description, @RequestParam Integer shift, @RequestParam Long id)
    {
        SectionDTO sectionDTO = sectionService.findSectionDTOById(id);
        sectionDTO.setDescription(description);
        sectionDTO.setShift(shift);
        sectionService.saveSection(sectionDTO);
        return "redirect:section";
    }

    @GetMapping("/addSection")
            String addSection()
    {
        return "addSection";
    }

    @PostMapping("/saveSection")
    String saveSection(@RequestParam String description, @RequestParam Integer shift){
        sectionService.saveSection(new SectionDTO(description, shift));
        return "redirect:section";
    }
    @GetMapping("/deleteSection")
    String deleteSection(@RequestParam Long id, Model model){
        if(employeeService.employeesBySection(id).isEmpty()) {
            managerService.modifySectionForManager(sectionService.findSectionById(id));
            sectionService.deleteSection(sectionService.findSectionDTOById(id));
            model.addAttribute("sections", sectionService.findSections());
            return "redirect:section";
        }
        else {
            return UriComponentsBuilder.fromPath("redirect:section")
                    .queryParam("value", "error")
                    .build().toString();
        }
    }
}
