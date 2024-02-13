package com.example.rcpproject.manager;

public class ManagerMapper {

    public static ManagerDTO mapperDTO(Manager manager) {
        ManagerDTO managerDTO = new ManagerDTO(manager.getFirstName(), manager.getLastName(), manager.getLogin(), manager.getPassword(), manager.getSections());
        managerDTO.setId(manager.getId());
        return managerDTO;
    }

    public static Manager mapperDTO(ManagerDTO managerDTO){
        Manager manager = new Manager(managerDTO.getFirstName(), managerDTO.getLastName(), managerDTO.getLogin(), managerDTO.getPassword(), managerDTO.getSections());
        if(managerDTO.getId()!=null) {
            manager.setId(managerDTO.getId());
        }
        return manager;
    }

    public static Manager mapperDTO(ManagerDTO managerDTO, Manager manager){
        manager.setFirstName(managerDTO.getFirstName());
        manager.setLastName(managerDTO.getLastName());
        manager.setLogin(managerDTO.getLogin());
        manager.setPassword(managerDTO.getPassword());
        manager.setSections(managerDTO.getSections());

        return manager;
    }
}
