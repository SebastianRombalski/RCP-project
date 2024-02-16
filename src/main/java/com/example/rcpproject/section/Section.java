package com.example.rcpproject.section;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min=2,max=50)
    private String description;
    @NonNull
    private int shift;

    public Section() {
    }

    public Section(@NonNull String description, int shift) {
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

    public int getShift() {
        return shift;
    }

    public void setShift(int shaft) {
        this.shift = shaft;
    }

    @Override
    public String toString() {
        return  "description='" + description + '\'' +
                ", shaft=" + shift;
    }
}
