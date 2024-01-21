package com.example.rcpproject.manager;

import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepo managerRepo;

    public ManagerService(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }
}
