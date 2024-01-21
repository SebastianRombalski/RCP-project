package com.example.rcpproject.section;

import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private final SectionRepo sectionRepo;

    public SectionService(SectionRepo sectionRepo) {
        this.sectionRepo = sectionRepo;
    }
}
