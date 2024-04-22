package com.example.rcpproject.manager;

import com.example.rcpproject.section.Section;
import com.example.rcpproject.section.SectionDTO;
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

    public Optional<ManagerDTO> findManager (String login){
      return managerRepo.findManagerByLogin(login).map(ManagerMapper::mapperDTO);

    }

    public Optional<ManagerDTOCredential> findCredentialByLogin (String login){
       return managerRepo.findManagerByLogin(login).map(MapperDTOCredentials::map);
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

    public void modifySectionForManager(Section section){
        List<Manager> managerList = managerRepo.findManagerBySections(section);
        for(int i=0; i<managerList.size(); i++){
            List<Section> sectionList = managerList.get(i).getSections();
            System.out.println("before remove");
            System.out.println(managerList.get(i));
            sectionList.remove(section);
            managerList.get(i).setSections(sectionList);
            System.out.println("after remove");
            System.out.println(managerList.get(i));
            managerRepo.save(managerList.get(i));
        }
    }
}
