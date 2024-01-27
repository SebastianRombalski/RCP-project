package com.example.rcpproject.event;

import com.example.rcpproject.employee.Employee;
import org.springframework.stereotype.Service;
import static com.example.rcpproject.event.EventMapper.mapperDTO;
import static com.example.rcpproject.event.EventInProgressMapper.mapperDTO;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

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

    public void addEvent(Employee employee){
        Optional<EventInProgress> eventInProgressOptional = eventInProgressRepo.findEventInProgressByEmployee_Id(employee.getId());
        if(eventInProgressOptional.isPresent()){
            LocalDateTime dateStart = eventInProgressOptional.get().getDateStart();
            eventRepo.save(new Event(dateStart, LocalDateTime.now(), eventInProgressOptional.get().getEmployee()));
            eventInProgressRepo.delete(eventInProgressOptional.get());
        }
        else{
            eventInProgressRepo.save(new EventInProgress(LocalDateTime.now(),employee ));
        }
    }

    public List<EventDTO> findAllEvent (){
        List<Event> allEvent = eventRepo.findAll();
        List<EventDTO> allEventDTO = new ArrayList<>();
        for (Event e : allEvent) {
            allEventDTO.add(mapperDTO(e));
        }
        return allEventDTO;
    }
    public List<EventInProgressDTO> findAllEventInProgress(){
        List<EventInProgress> allEventInProgress = eventInProgressRepo.findAll();
        List<EventInProgressDTO> allEventInProgressDTO = new ArrayList<>();
        for (EventInProgress e: allEventInProgress ) {
            allEventInProgressDTO.add(mapperDTO(e));
        }
        return allEventInProgressDTO;
    }

}
