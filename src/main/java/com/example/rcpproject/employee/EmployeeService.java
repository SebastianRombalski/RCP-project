package com.example.rcpproject.employee;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.rcpproject.employee.EmployeeMapper.mapperDTO;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo ) {
        this.employeeRepo = employeeRepo;
    }

    public List<EmployeeDTO> employeesBySection(Long sectionId){
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        List<Employee> employees = employeeRepo.findEmployeesBySection_id(sectionId);
        for (Employee employee:employees)
             {employeeDTOList.add(mapperDTO(employee));
             }
            return employeeDTOList;
    }

    public EmployeeDTO employeeByLogin (String loginCode) {
//    Optional<Employee> employee = employeeRepo.findEmployeeByLoginCode(loginCode);
//
//    if(employee.isPresent()){
//        return mapperDTO(employee.get());
//    }
//    else return null;

        Optional<Employee> employee = employeeRepo.findEmployeeByLoginCode(loginCode);
         return  employee.map(EmployeeMapper::mapperDTO).get();
}

    public void saveEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(mapperDTO(employeeDTO));
    }

    public void deleteEmployee(Long employeeId){
        employeeRepo.deleteById(employeeId);
    }

    @Transactional
    public void modifyEmployee(EmployeeDTO employeeDTO, Long employeeId){

        Optional<Employee> employee = employeeRepo.findById(employeeId);
        if (employee.isPresent()){
            Employee employee1 = employee.get();
            employee1.setSection(employeeDTO.getSection());
            employee1.setLoginCode(employeeDTO.getLoginCode());
            employee1.setLastName(employeeDTO.getLastName());
            employee1.setFirstName(employeeDTO.getFirstName());
            employeeRepo.save(employee1);
        }
    }
}
