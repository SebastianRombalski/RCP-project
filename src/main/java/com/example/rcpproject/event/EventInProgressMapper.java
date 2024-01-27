package com.example.rcpproject.event;

 class EventInProgressMapper {
     static EventInProgressDTO mapperDTO(EventInProgress eventInProgress){
      EventInProgressDTO eventInProgressDTO = new EventInProgressDTO(eventInProgress.getDateStart(), eventInProgress.getEmployee());
      return eventInProgressDTO;
     }
}
