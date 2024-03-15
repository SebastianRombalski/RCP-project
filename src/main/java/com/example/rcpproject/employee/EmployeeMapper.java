package com.example.rcpproject.employee;



public class EmployeeMapper {

    public static Employee mapperDTO (EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setLoginCode(employeeDTO.getLoginCode());
        employee.setSection(employeeDTO.getSection());
        employee.setId(employeeDTO.getId());
        employee.setStatus(employeeDTO.getStatus());

        return employee;

    }

    public static Employee mapperDTO (EmployeeDTO employeeDTO , Employee employee){
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setLoginCode(employeeDTO.getLoginCode());
        employee.setSection(employeeDTO.getSection());
        employee.setStatus(employeeDTO.getStatus());

        return employee;

    }

    public static EmployeeDTO mapperDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getLoginCode(),
                employee.getStatus(),
                employee.getSection()
        );

        return employeeDTO;
    }

}
