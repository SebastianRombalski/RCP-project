package com.example.rcpproject.employee;

import org.springframework.context.annotation.Bean;

import java.util.Optional;


class EmployeeMapper {

    public static Employee mapperDTO (EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setLoginCode(employeeDTO.getLoginCode());
        employee.setSection(employeeDTO.getSection());

        return employee;

    }

    public static EmployeeDTO mapperDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setSection(employee.getSection());
        employeeDTO.setLoginCode(employee.getLoginCode());

        return employeeDTO;
    }

}
