package com.example.rcpproject.section;

public class SectionMapper {

    public static Section mapperDTO (SectionDTO sectionDTO){
        Section section = new Section(sectionDTO.getDescription(), sectionDTO.getShift());
        if(sectionDTO.getId()!=null) {
            section.setId(sectionDTO.getId());
        }
        return section;
    }
    public static SectionDTO mapperDTO (Section section){
        SectionDTO sectionDTO = new SectionDTO(section.getId(), section.getDescription(), section.getShift());
        return sectionDTO;
    }
}
