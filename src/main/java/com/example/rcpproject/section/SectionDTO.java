package com.example.rcpproject.section;


import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class SectionDTO {
    @NonNull
    @Size(min=2,max=50)
    private String description;
    @NonNull
    private int shift;

    private Long id;

    public SectionDTO() {
    }

    public SectionDTO(Long id,@NonNull String description,@NonNull int shift) {
        this.description = description;
        this.shift = shift;
        this.id = id;
    }

    public SectionDTO(@NonNull String description,@NonNull int shift) {
        this.description = description;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
    @NonNull
    public int getShift() {
        return shift;
    }

    public void setShift(@NonNull int shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return   "description='" + description + '\'' +
                ", shift=" + shift
                ;
    }
}
