package com.example.rcpproject.event;

class EventMapper {

    static EventDTO mapperDTO (Event event){
        EventDTO eventDTO = new EventDTO(event.getDateStart(),event.getDateStop(), event.getEmployee());
        return eventDTO;
    }
}
