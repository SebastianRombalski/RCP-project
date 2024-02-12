package com.example.rcpproject.manager;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.rcpproject.manager.ManagerMapper.mapperDTO;

@Service
public class ManagerService {

    private final ManagerRepo managerRepo;

    public ManagerService(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    public void saveManager(ManagerDTO managerDTO){
        managerRepo.save(mapperDTO(managerDTO));
    }

    public ManagerDTO findManager (String login){
        Optional<Manager> managerOptional = managerRepo.findManagerByLogin(login);

       return managerOptional.map(ManagerMapper::mapperDTO).orElse(null);
    }
    
    public List<ManagerDTO> findAllManagers (){
        List<Manager> managerList = managerRepo.findAll();
        List<ManagerDTO> managerDTOList = new ArrayList<>();
        for (Manager m: managerList
             ) {
            managerDTOList.add(mapperDTO(m));
        }
        return managerDTOList;
    }

    public void deleteManager (Long id){
        managerRepo.deleteById(id);
    }

    public ManagerDTO findManagerById(Long id){

return managerRepo.findById(id).map(ManagerMapper::mapperDTO).orElse(null);
    }
}
