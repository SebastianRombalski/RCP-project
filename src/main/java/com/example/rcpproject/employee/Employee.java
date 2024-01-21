package com.example.rcpproject.employee;

import com.example.rcpproject.section.Section;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min =2,max = 50)
    private String firstName;
    @NonNull
    @Size(min =2,max = 50)
    private String lastName;
    @NonNull
    @Size(min = 5, max = 100)
    private String loginCode;

    @OneToOne
    @NonNull
    private Section section;

    public Employee(@NonNull String firstName, @NonNull String lastName, @NonNull String loginCode, @NonNull Section section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String name) {
        this.firstName = name;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String surname) {
        this.lastName = surname;
    }

    @NonNull
    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(@NonNull String loginCode) {
        this.loginCode = loginCode;
    }
    @NonNull
    public Section getSection() {
        return section;
    }

    public void setSection(@NonNull Section section) {
        this.section = section;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + lastName + '\'' +
                ", loginCode='" + loginCode + '\'' +
                '}';
    }
}
