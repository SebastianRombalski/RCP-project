package com.example.rcpproject.manager;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ManagerDetailService implements UserDetailsService {

    private final ManagerService managerService;

    public ManagerDetailService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("blad jest w username");
        return managerService.findManager(username).map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));

    }

    private UserDetails createUserDetails(ManagerDTO managerDTO){
        System.out.println("blad jest w createUserDetails");
        return User.builder().username(managerDTO.getLogin())
                .password(managerDTO.getPassword()).roles(managerDTO.getRole().getRoleName()).build();
    }
}
