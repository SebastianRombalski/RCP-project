package com.example.rcpproject.section;

import org.springframework.stereotype.Service;
import static com.example.rcpproject.section.SectionMapper.mapperDTO;

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
    public SectionDTO findSection(String description, int shift){
        return sectionRepo.findSectionByDescriptionAndShift(description,shift).map(SectionMapper::mapperDTO).orElse(null);
    }
}
