package com.example.rcpproject.role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public Role findRole(Long id){
        return roleRepo.findRoleById(id).orElse(null);
    }
}
