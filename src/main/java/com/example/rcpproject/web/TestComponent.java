package com.example.rcpproject.web;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class TestComponent {



    @EventListener(ApplicationReadyEvent.class)
    public void Start(){


    }
}
