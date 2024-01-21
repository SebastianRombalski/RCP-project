package com.example.rcpproject.eventinprogress;

import org.springframework.stereotype.Service;

@Service
public class EventInProgressService {

    private final EventInProgressRepo eventInProgressRepo;


    public EventInProgressService(EventInProgressRepo eventInProgressRepo) {
        this.eventInProgressRepo = eventInProgressRepo;
    }
}
