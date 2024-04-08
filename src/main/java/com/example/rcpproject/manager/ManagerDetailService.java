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
      //  return managerService.findManager(username);
        return null;
    }

    private UserDetails createUserDetails(ManagerDTO managerDTO){
        return User.builder().username(managerDTO.getLogin())
                .password(managerDTO.getPassword())
                .roles(managerDTO.getSections().toArray(String[]::new)).build();
    }
}
