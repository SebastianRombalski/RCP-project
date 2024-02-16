package com.example.rcpproject.controller;

import com.example.rcpproject.section.Section;
import com.example.rcpproject.section.SectionDTO;
import com.example.rcpproject.section.SectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SectionController {
    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/section")
    String section(Model model){
        model.addAttribute("sections", sectionService.findSections());
        return "section";
    }

    @PostMapping("/editSection")
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
}
