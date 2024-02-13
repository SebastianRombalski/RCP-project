package com.example.rcpproject.controller;

import com.example.rcpproject.manager.Manager;
import com.example.rcpproject.manager.ManagerDTO;
import com.example.rcpproject.manager.ManagerService;
import com.example.rcpproject.section.SectionDTO;
import com.example.rcpproject.section.SectionMapper;
import com.example.rcpproject.section.SectionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagerController {
   private final ManagerService managerService;
   private final SectionService sectionService;

    public ManagerController(ManagerService managerService, SectionService sectionService) {
        this.managerService = managerService;
        this.sectionService = sectionService;
    }

    @GetMapping("manager")
    String manager(Model model){
        model.addAttribute("manager", managerService.findAllManagers());
        return "manager";
    }

    @PostMapping ("/deleteManager")
    String deleteManager(@RequestParam Long id){
        managerService.deleteManager(id);
        return "redirect:manager";
    }

    @PostMapping("/editManager")
    String editManager(@RequestParam Long id, Model model){
        ManagerDTO managerDTO = managerService.findManagerById(id);
        List<SectionDTO> sectionList = sectionService.findSections();
        List<SectionDTO> sectionManagerList = managerDTO.getSections().stream().map(SectionMapper::mapperDTO).toList();
        List<SectionDTO> otherSectionList = new ArrayList<>();


        for(int i=0; i<sectionList.size();i++){
            boolean check = false;
            for(int y=0; y<sectionManagerList.size() ;y++){
                if (sectionList.get(i).getId() == sectionManagerList.get(y).getId()){
                    check=true;
                }
            }
            if(!check){
               otherSectionList.add(sectionList.get(i));
            }
        }

        model.addAttribute("manager", managerDTO);
        model.addAttribute("managerSection", sectionManagerList);

            model.addAttribute("otherSection", otherSectionList);
        return "editManager";
    }

    @PostMapping("/saveEditManager")
        String saveEditManager(HttpServletRequest request){
        List<SectionDTO> sectionList = sectionService.findSections();
        List<SectionDTO> updatedSectionList = new ArrayList<>();
        for(int i=0 ; i<sectionList.size(); i++)
        {
            String s = sectionList.get(i).getId().toString();
            if(!(request.getParameter(s)==null)){
                updatedSectionList.add(sectionList.get(i));
            }

        }
        ManagerDTO managerDTO = managerService.findManagerById(Long.valueOf(request.getParameter("id")));
        System.out.println(managerDTO);
        managerDTO.setFirstName(request.getParameter("firstName"));
        managerDTO.setLastName(request.getParameter("lastName"));
        managerDTO.setLogin(request.getParameter("login"));
        managerDTO.setSections(updatedSectionList.stream().map(SectionMapper::mapperDTO).toList());
        managerService.saveManager(managerDTO);
            return "redirect:manager";
        }


        @GetMapping("/addManager")
    String addManager(Model model){
        model.addAttribute("section", sectionService.findSections());
        return "addManager";
        }

        @PostMapping("/saveManager")
    String saveManager(HttpServletRequest request){
        List<SectionDTO> sectionList = sectionService.findSections();
        List<SectionDTO> sectionManagerList= new ArrayList<>();
            for(int i=0 ; i<sectionList.size(); i++)
            {
                String s = sectionList.get(i).getId().toString();
                if(!(request.getParameter(s)==null)){
                    sectionManagerList.add(sectionList.get(i));
                }

            }
            ManagerDTO managerDTO = new ManagerDTO();
            managerDTO.setFirstName(request.getParameter("firstName"));
            managerDTO.setLastName(request.getParameter("lastName"));
            managerDTO.setLogin(request.getParameter("login"));
            managerDTO.setPassword(request.getParameter("password"));
            managerDTO.setSections(sectionManagerList.stream().map(SectionMapper::mapperDTO).toList());
            managerService.saveManager(managerDTO);
            return "redirect:manager";
        }
    }

