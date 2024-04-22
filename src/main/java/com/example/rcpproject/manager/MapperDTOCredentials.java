package com.example.rcpproject.manager;

public class MapperDTOCredentials {
    static ManagerDTOCredential map(Manager manager){
        return new ManagerDTOCredential (manager.getLogin(), manager.getPassword(), manager.getRole().toString());
    }
}
