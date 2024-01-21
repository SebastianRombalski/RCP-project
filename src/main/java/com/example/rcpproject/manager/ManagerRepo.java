package com.example.rcpproject.manager;

import com.example.rcpproject.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ManagerRepo extends JpaRepository<Manager, Long> {
}
