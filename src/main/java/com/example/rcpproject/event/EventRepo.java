package com.example.rcpproject.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
 interface EventRepo extends JpaRepository<Event,Long> {

    List<Event> findEventsByEmployee_id(Long id);
    List<Event> findEventsByDateStartBetween(LocalDateTime localDate, LocalDateTime localDate2);
}
