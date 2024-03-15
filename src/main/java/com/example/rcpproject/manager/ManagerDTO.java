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
    @NonNull
    @Size(min =2,max = 50)
    private String firstName;
    @NonNull
    @Size(min =2,max = 50)
    private String lastName;
    @NonNull
    @Size(min =2,max = 100)
    private String login;
    @NonNull
    @Size(min =2,max = 255)
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


    public ManagerDTO(@NonNull String firstName,@NonNull String lastName,@NonNull String login,@NonNull String password, List<Section> sections) {
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
    public String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }
    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
