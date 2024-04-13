package com.example.rcpproject.manager;

import com.example.rcpproject.role.Role;
import com.example.rcpproject.section.Section;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerDTO {

    private Long id;
    @NotNull
    @Size(min =2,max = 50)
    private String firstName;
    @NotNull
    @Size(min =2,max = 50)
    private String lastName;
    @NotNull
    @Size(min =2,max = 100)
    private String login;
    @NotNull
    @Size(min =2,max = 255)
    private String password;
    private List<Section> sections = new ArrayList<>();

    @NotNull
    private Role role;

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


    public ManagerDTO(@NotNull String firstName,@NotNull String lastName,@NotNull String login,@NotNull String password, List<Section> sections, @NotNull Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.sections = sections;
        this.role=role;
    }

    public ManagerDTO() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
    public String getLogin() {
        return login;
    }

    public void setLogin(@NotNull String login) {
        this.login = login;
    }
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
