package com.example.rcpproject.employee;

import com.example.rcpproject.section.Section;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.NonNull;


public class EmployeeDTO {

    private Long id;
    @NotNull(message = "First name cannot be null")
    @Size(min =2,max = 50, message = "First Name must have from 2 to 50 character")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Size(min =2,max = 50, message = "Last Name must have from 2 to 50 character")
    private String lastName;
    @NotNull(message = "Login code cannot be null")
    @Size(min =2,max = 50, message = "Login code must have from 2 to 100 character")
    private String loginCode;
    @NotNull (message = "Section cannot be null")
    private Section section;
    @NotNull (message = "Status cannot be null")
    private String status;

    public EmployeeDTO(@NotNull String firstName, @NotNull String lastName, @NotNull String loginCode,@NotNull String status, @NotNull Section section ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
        this.status = status;
    }

    public EmployeeDTO(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull String loginCode,@NotNull String status, @NotNull Section section) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginCode = loginCode;
        this.section = section;
        this.status = status;
    }

    public EmployeeDTO() {
    status="active";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(@NotNull String loginCode) {
        this.loginCode = loginCode;
    }

    @NotNull
    public Section getSection() {
        return section;
    }

    public void setSection(@NotNull Section section) {
        this.section = section;
    }

    @NotNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }
}
