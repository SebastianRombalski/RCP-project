package com.example.rcpproject.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
 interface EventRepo extends JpaRepository<Event,Long> {

    List<Event> findEventsByEmployee_id(Long id);

    List<Event> findEventsByDateStartAfter(LocalDateTime fromDate);
    List<Event> findEventsByDateStartBefore(LocalDateTime toDate);
    List<Event> findEventsByDateStartBetween(LocalDateTime fromDate, LocalDateTime toDate);

    List<Event> findEventsByEmployee_IdAndDateStartAfter(Long id,LocalDateTime fromDate);
    List<Event> findEventsByEmployee_IdAndDateStartBefore(Long id, LocalDateTime toDate);
    List<Event> findEventsByEmployee_IdAndDateStartBetween(Long id, LocalDateTime fromDate, LocalDateTime toDate);
}
