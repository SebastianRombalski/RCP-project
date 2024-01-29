package com.example.rcpproject.employee;

import org.springframework.stereotype.Service;

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

            Optional<Employee> employeeOptional = employeeRepo.findEmployeeByLoginCode(loginCode);
                return employeeOptional.map(EmployeeMapper::mapperDTO).orElse(null);

}

    public void saveEmployee(EmployeeDTO employeeDTO){
        employeeRepo.save(mapperDTO(employeeDTO));
    }

    public void deleteEmployee(Long employeeId){
        employeeRepo.deleteById(employeeId);
    }

    public void modifyEmployee(EmployeeDTO employeeDTO, Long employeeId){

        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()){

            employeeRepo.save(mapperDTO(employeeDTO, employeeOptional.get()));
        }
        else System.out.println("Taki pracownik nie istnieje");
    }

    public Optional<EmployeeDTO> employeeByLoginCode(String loginCode){

        return employeeRepo.findEmployeeByLoginCode(loginCode).map(EmployeeMapper::mapperDTO);
    }
}
