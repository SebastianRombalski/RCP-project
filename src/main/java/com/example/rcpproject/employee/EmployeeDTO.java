package com.example.rcpproject.employee;

import com.example.rcpproject.section.Section;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;


public class EmployeeDTO {

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
    @NonNull
    private Section section;
    @NonNull
    private String status;

    public EmployeeDTO(@NonNull String firstName, @NonNull String lastName, @NonNull String loginCode,@NonNull String status, @NonNull Section section ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
        this.status = status;
    }

    public EmployeeDTO(Long id, @NonNull String firstName, @NonNull String lastName, @NonNull String loginCode,@NonNull String status, @NonNull Section section) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
        this.status = status;
    }

    public EmployeeDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
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

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }
}
