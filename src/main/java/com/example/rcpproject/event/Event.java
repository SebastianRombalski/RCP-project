package com.example.rcpproject.event;

import com.example.rcpproject.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @PastOrPresent
    private LocalDateTime dateStart;

    @NonNull
    @PastOrPresent
    private LocalDateTime dateStop;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NonNull
    private Employee employee;

    public Event() {
    }

    public Event(@NonNull LocalDateTime dateStart, @NonNull LocalDateTime dateStop, @NonNull Employee employee) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
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
    public LocalDateTime getDateStop() {
        return dateStop;
    }

    public void setDateStop(@NonNull LocalDateTime dateStop) {
        this.dateStop = dateStop;
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
        return "Event{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateStop=" + dateStop +
                ", employee=" + employee +
                '}';
    }
}

