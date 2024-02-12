package com.example.rcpproject.manager;

import com.example.rcpproject.section.Section;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private List<Section> sections = new ArrayList<>();

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sections=" + sections +
                '}';
    }

    public ManagerDTO(String firstName, String lastName, String password, List<Section> sections) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = firstName + "." + lastName;
        this.password = password;
        this.sections = sections;
    }

    public ManagerDTO(String firstName, String lastName, String login, String password, List<Section> sections) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.sections = sections;
    }

    public ManagerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
