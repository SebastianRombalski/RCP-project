package com.example.rcpproject.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findRolesById(Long id);
}
