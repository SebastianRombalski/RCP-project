package com.example.rcpproject.controller;

import com.example.rcpproject.manager.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {
   private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("manager")
    String manager(Model model){
        model.addAttribute("manager", managerService.findAllManagers());
        return "manager";
    }
}
