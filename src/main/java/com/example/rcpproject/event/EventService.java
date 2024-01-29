package com.example.rcpproject.event;

import com.example.rcpproject.employee.EmployeeDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import static com.example.rcpproject.event.EventMapper.mapperDTO;
import static com.example.rcpproject.event.EventInProgressMapper.mapperDTO;
import static com.example.rcpproject.employee.EmployeeMapper.mapperDTO;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService  {

    private final EventRepo eventRepo;
    private final EventInProgressRepo eventInProgressRepo;

    public EventService(EventRepo eventRepo, EventInProgressRepo eventInProgressRepo) {
        this.eventRepo = eventRepo;
        this.eventInProgressRepo = eventInProgressRepo;
    }

    public List<EventDTO> eventsByEmployee (Long employeeId){
        List<EventDTO> eventDTOList = new ArrayList<>();
        List<Event> eventsByEmployee_id = eventRepo.findEventsByEmployee_id(employeeId);

        for (Event event:eventsByEmployee_id
             ) {
            eventDTOList.add(mapperDTO(event));
        }
        return eventDTOList;
    }

    public boolean addEvent(EmployeeDTO employeeDTO){
        Optional<EventInProgress> eventInProgressOptional = eventInProgressRepo.findEventInProgressByEmployee_Id(employeeDTO.getId());
        if(eventInProgressOptional.isPresent()){
            LocalDateTime dateStart = eventInProgressOptional.get().getDateStart();
            eventRepo.save(new Event(dateStart, LocalDateTime.now(), eventInProgressOptional.get().getEmployee()));
            eventInProgressRepo.delete(eventInProgressOptional.get());
            return true;
        }
        else{
            eventInProgressRepo.save(new EventInProgress(LocalDateTime.now(),mapperDTO(employeeDTO)));
            return false;
        }
    }

    public List<EventDTO> findAllEvent (){
        List<Event> allEvent = eventRepo.findAll(Sort.by(Sort.Direction.ASC, "employee_lastName"));
        List<EventDTO> allEventDTO = new ArrayList<>();
        for (Event e : allEvent) {
            allEventDTO.add(mapperDTO(e));
        }
        return allEventDTO;
    }
    public List<EventInProgressDTO> findAllEventInProgress(){
        List<EventInProgress> allEventInProgress = eventInProgressRepo.findAll(Sort.by(Sort.Direction.ASC, "employee_lastName"));
        List<EventInProgressDTO> allEventInProgressDTO = new ArrayList<>();
        for (EventInProgress e: allEventInProgress ) {
            allEventInProgressDTO.add(mapperDTO(e));
        }
        return allEventInProgressDTO;
    }


}
