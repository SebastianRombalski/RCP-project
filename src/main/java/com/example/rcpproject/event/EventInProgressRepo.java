package com.example.rcpproject.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface EventInProgressRepo extends JpaRepository<EventInProgress, Long> {
    Optional<EventInProgress> findEventInProgressByEmployee_Id(Long id);
}
