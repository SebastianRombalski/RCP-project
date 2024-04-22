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
        return managerService.findCredentialByLogin(username).map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));

    }

    private UserDetails createUserDetails(ManagerDTOCredential managerDTOCredential){
        System.out.println("blad jest w createUserDetails");
        return User.builder().username(managerDTOCredential.getLogin())
                .password(managerDTOCredential.getPassword()).roles(managerDTOCredential.getRole()).build();
    }
}
