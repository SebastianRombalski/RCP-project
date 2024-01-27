package com.example.rcpproject.web;


import com.example.rcpproject.employee.EmployeeService;
import com.example.rcpproject.event.EventService;
import com.example.rcpproject.manager.ManagerDTO;
import com.example.rcpproject.manager.ManagerService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class TestComponent {

    private final EmployeeService employeeService;
private final EventService eventService;
private final ManagerService managerService;

    public TestComponent(EmployeeService employeeService, EventService eventService, ManagerService managerService) {
        this.employeeService = employeeService;
        this.eventService = eventService;
        this.managerService = managerService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void Start(){
        System.out.println(managerService.findManager("andrzej.jakis"));
        System.out.println("--------------");

        System.out.println(managerService.findAllManagers());


    }
}
