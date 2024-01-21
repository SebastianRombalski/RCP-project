package com.example.rcpproject.eventinprogress;

import com.example.rcpproject.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "events_in_progress")
public class EventInProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @PastOrPresent
    private LocalDateTime dateStart;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @NonNull
    private Employee employee;

    public EventInProgress() {
    }

    public EventInProgress(@NonNull LocalDateTime dateStart, @NonNull Employee employee) {
        this.dateStart = dateStart;
        this.employee = employee;
    }

    @NonNull
    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(@NonNull LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    @NonNull
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NonNull Employee employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EventInProgress{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                '}';
    }
}
