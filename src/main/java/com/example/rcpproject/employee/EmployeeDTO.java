package com.example.rcpproject.employee;

import com.example.rcpproject.section.Section;


public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String loginCode;
    private Section section;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeDTO(Long id, String firstName, String lastName, String loginCode, Section section) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
    }

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loginCode='" + loginCode + '\'' +
                ", section=" + section +
                '}';
    }
}
