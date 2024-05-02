package com.example.rcpproject.employee;

import jakarta.transaction.Transactional;
import org.springframework.security.core.parameters.P;
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

//    public void deleteEmployee(Long employeeId){
//        employeeRepo.deleteById(employeeId);
//    }
//
//    public void modifyEmployee(EmployeeDTO employeeDTO, Long employeeId){
//
//        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
//        if (employeeOptional.isPresent()){
//
//            employeeRepo.save(mapperDTO(employeeDTO, employeeOptional.get()));
//        }
//        else System.out.println("Taki pracownik nie istnieje");
//    }

    public Optional<EmployeeDTO> employeeByLoginCode(String loginCode){

        return employeeRepo.findEmployeeByLoginCode(loginCode).map(EmployeeMapper::mapperDTO);
    }

    public EmployeeDTO employeeById(Long id){
        return employeeRepo.findById(id).map(EmployeeMapper::mapperDTO).orElse(null);
    }


    public void changeStatus(Long id){
        Employee employee = employeeRepo.findById(id).orElse(null);
        if(employee.getStatus().equals("active")) {
            employee.setStatus("inactive");
        }
        else employee.setStatus("active");

        employeeRepo.save(employee);
    }

    public List<EmployeeDTO> findEmployees(){
       return employeeRepo.findAll().stream().map(EmployeeMapper::mapperDTO).toList();
    }

    public boolean checkLoginCode(String loginCode){
        Optional<Employee> employeeByLoginCode = employeeRepo.findEmployeeByLoginCode(loginCode);
        if(employeeByLoginCode.isPresent()) {
            return true;
        }
        else return false;
    }

    public List<EmployeeDTO> findEmployeeBySections(List<Long> sectionIds){
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Long sectionId : sectionIds){
            employeeDTOList.addAll(employeeRepo.findEmployeesBySection_id(sectionId).stream().map(EmployeeMapper::mapperDTO).toList());
        }

        return employeeDTOList;
    }

}
