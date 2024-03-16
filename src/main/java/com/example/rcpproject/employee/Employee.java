package com.example.rcpproject.employee;

import com.example.rcpproject.section.Section;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min =2,max = 50)
    private String firstName;
    @NotNull
    @Size(min =2,max = 50)
    private String lastName;
    @NotNull
    @Size(min = 5, max = 100)
    private String loginCode;

    @NotNull
    private String status;

    @OneToOne
    @NotNull
    private Section section;

    public Employee(@NotNull String firstName, @NotNull String lastName, @NotNull String loginCode, @NotNull Section section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
        this.status = "active";
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String name) {
        this.firstName = name;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String surname) {
        this.lastName = surname;
    }

    @NotNull
    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(@NotNull String loginCode) {
        this.loginCode = loginCode;
    }

    @NotNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }

    @NotNull
    public Section getSection() {
        return section;
    }

    public void setSection(@NotNull Section section) {
        this.section = section;
    }



}
