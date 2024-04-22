package com.example.rcpproject.manager;

public class ManagerDTOCredential {
    private String login;
    private String password;
    private String role;

    public ManagerDTOCredential(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }


    public String getRole() {
        return role;
    }


}
