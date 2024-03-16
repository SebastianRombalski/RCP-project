package com.example.rcpproject.section;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class SectionDTO {
    @NotNull
    @Size(min=2,max=50)
    private String description;
    @NotNull
    private int shift;

    private Long id;

    public SectionDTO() {
    }

    public SectionDTO(Long id,@NotNull String description,@NotNull int shift) {
        this.description = description;
        this.shift = shift;
        this.id = id;
    }

    public SectionDTO(@NotNull String description,@NotNull int shift) {
        this.description = description;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }
    @NotNull
    public int getShift() {
        return shift;
    }

    public void setShift(@NotNull int shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return   "description='" + description + '\'' +
                ", shift=" + shift
                ;
    }
}
