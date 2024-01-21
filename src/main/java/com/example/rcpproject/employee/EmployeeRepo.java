package com.example.rcpproject.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeRepo extends JpaRepository<Employee,Long> {

   List<Employee> findEmployeesBySection_id(Long id);
   Optional<Employee> findEmployeeByLoginCode(String loginCode);

}
