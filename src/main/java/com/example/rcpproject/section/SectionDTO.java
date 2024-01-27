package com.example.rcpproject.section;



public class SectionDTO {

    private String description;
    private int shift;

    public SectionDTO() {
    }

    public SectionDTO(String description, int shift) {
        this.description = description;
        this.shift = shift;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "description='" + description + '\'' +
                ", shift=" + shift +
                '}';
    }
}
