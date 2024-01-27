package com.example.rcpproject.manager;

import com.example.rcpproject.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
interface ManagerRepo extends JpaRepository<Manager, Long> {
    Optional<Manager> findManagerByLogin(String login);
}
