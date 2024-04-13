package com.example.rcpproject.manager;

import com.example.rcpproject.role.Role;
import com.example.rcpproject.section.Section;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "managers")
public class Manager {

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
    @Size(min =2,max = 100)
    private String login;
    @NotNull
    @Size(min =2,max = 255)
    private String password;
    @NotNull
    @OneToOne
    private Role role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="manager_sections",
            joinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "section_id", referencedColumnName = "id"))
    private List<Section> sections = new ArrayList<>();

    public Manager() {
    }

    public Manager(@NotNull String firstName, @NotNull String lastName, @NotNull String login, @NotNull String password, @NotNull Role role, List<Section> sections) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.role = role;
        String correctPassword = "{argon2}"+ Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8().encode(password);
        this.password = correctPassword;
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password +
                '}';
    }
}
