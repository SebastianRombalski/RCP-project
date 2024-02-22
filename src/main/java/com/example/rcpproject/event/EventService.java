package com.example.rcpproject.event;

import com.example.rcpproject.employee.EmployeeDTO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cglib.core.Local;
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



    public List<EventDTO> findEventByEmployeeBetweenDate(Long id, String fromDate, String toDate){
        if (fromDate.isEmpty() && toDate.isEmpty() && id == 0) {
                return eventRepo.findAll().stream().map(EventMapper::mapperDTO).toList();
            } else {
                if (id != 0 && fromDate.isEmpty() && toDate.isEmpty()) {
                    return eventRepo.findEventsByEmployee_id(id).stream().map(EventMapper::mapperDTO).toList();
                } else if (id != 0 && !fromDate.isEmpty() && toDate.isEmpty()) {
                    return eventRepo.findEventsByEmployee_IdAndDateStartAfter(id, parseDateTimeStartDay(fromDate)).stream().map(EventMapper::mapperDTO).toList();
                } else if (id != 0 && fromDate.isEmpty() && !toDate.isEmpty()) {
                    return eventRepo.findEventsByEmployee_IdAndDateStartBefore(id,parseDateTimeEndDay(toDate)).stream().map(EventMapper::mapperDTO).toList();
                } else if (id != 0 && !fromDate.isEmpty() && !toDate.isEmpty()) {
                    return eventRepo.findEventsByEmployee_IdAndDateStartBetween(id, parseDateTimeStartDay(fromDate), parseDateTimeEndDay(toDate)).stream().map(EventMapper::mapperDTO).toList();
                } else if (id == 0 && !fromDate.isEmpty() && toDate.isEmpty()) {
                    return eventRepo.findEventsByDateStartAfter(parseDateTimeStartDay(fromDate)).stream().map(EventMapper::mapperDTO).toList();
                } else if (id == 0 && fromDate.isEmpty() && !toDate.isEmpty()) {
                    return eventRepo.findEventsByDateStartBefore(parseDateTimeEndDay(toDate)).stream().map(EventMapper::mapperDTO).toList();
                } else if (id == 0 && !fromDate.isEmpty() && !toDate.isEmpty()) {
                    return eventRepo.findEventsByDateStartBetween(parseDateTimeStartDay(fromDate), parseDateTimeEndDay(toDate)).stream().map(EventMapper::mapperDTO).toList();
                }
                else return null;
            }
    }


    private LocalDateTime parseDateTimeStartDay(String data){
        String dateWithTime = new StringBuilder(data + "T00:00:00").toString();
        return LocalDateTime.parse(dateWithTime);
    }
    private LocalDateTime parseDateTimeEndDay(String data){
        System.out.println(LocalDateTime.now());
        String dateWithTime = new StringBuilder(data + "T23:59:59").toString();
        return LocalDateTime.parse(dateWithTime);
    }


}
