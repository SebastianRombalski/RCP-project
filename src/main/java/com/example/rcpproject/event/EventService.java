package com.example.rcpproject.event;

import com.example.rcpproject.employee.Employee;
import com.example.rcpproject.employee.EmployeeDTO;
import com.example.rcpproject.employee.EmployeeMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.example.rcpproject.event.EventMapper.mapperDTO;
import static com.example.rcpproject.event.EventInProgressMapper.mapperDTO;
import static com.example.rcpproject.employee.EmployeeMapper.mapperDTO;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService  {

    private final EventRepo eventRepo;
    private final EventInProgressRepo eventInProgressRepo;

    DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");

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
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        String formatedData = localDateTimeNow.format(formatterDate);
        String formateTime = localDateTimeNow.format(formatterTime);
        System.out.println(formatedData + "T" + formateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(formatedData + "T" + formateTime);

        if(eventInProgressOptional.isPresent()){
            LocalDateTime dateStart = eventInProgressOptional.get().getDateStart();

            eventRepo.save(new Event(dateStart, localDateTime, eventInProgressOptional.get().getEmployee()));
            eventInProgressRepo.delete(eventInProgressOptional.get());
            return true;
        }
        else{
            eventInProgressRepo.save(new EventInProgress(localDateTime,mapperDTO(employeeDTO)));
            return false;
        }
    }

    public List<EventDTO> findAllEvent (){
        List<Event> allEvent = eventRepo.findAll(Sort.by(Sort.Direction.DESC, "employee_lastName"));
        List<EventDTO> allEventDTO = new ArrayList<>();
        for (Event e : allEvent) {
            allEventDTO.add(mapperDTO(e));
        }
        return allEventDTO;
    }
    public List<EventInProgressDTO> findAllEventInProgress(){
        List<EventInProgress> allEventInProgress = eventInProgressRepo.findAll(Sort.by(Sort.Direction.DESC, "employee_lastName"));
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

    public EventDTO findEventById(Long id){
       return eventRepo.findById(id).map(EventMapper::mapperDTO).orElse(null);
    }

    public void saveChangedEvent(LocalDateTime startTime, LocalDateTime stopTime, Long id){
        Event event = eventRepo.findById(id).get();
        event.setDateStart(startTime);
        event.setDateStop(stopTime);
        eventRepo.save(event);
    }

    public void deleteEvent(Long id){
        eventRepo.delete(eventRepo.findById(id).get());
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


    public void saveEvent(String startTime, String stopTime, EmployeeDTO employee ) {
        eventRepo.save(new Event(LocalDateTime.parse(startTime), LocalDateTime.parse(stopTime), EmployeeMapper.mapperDTO(employee)));
    }
}
