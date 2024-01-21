package com.example.rcpproject.event;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }
}
