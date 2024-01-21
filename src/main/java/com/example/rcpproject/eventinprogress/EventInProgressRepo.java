package com.example.rcpproject.eventinprogress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EventInProgressRepo extends JpaRepository<EventInProgress, Long> {
    EventInProgress findEventInProgressByEmployee_LoginCode(String loginCode);
    Boolean existsEventInProgressByEmployee_LoginCode(String loginCode);
}
