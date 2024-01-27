package com.example.rcpproject.section;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    private final SectionRepo sectionRepo;

    public SectionService(SectionRepo sectionRepo) {
        this.sectionRepo = sectionRepo;
    }

    public List<Section> findSections (){

        return sectionRepo.findAll();
    }
}
