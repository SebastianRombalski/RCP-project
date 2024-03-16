package com.example.rcpproject.event;

import com.example.rcpproject.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PastOrPresent
    private LocalDateTime dateStart;

    @NotNull
    @PastOrPresent
    private LocalDateTime dateStop;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotNull
    private Employee employee;

    public Event() {
    }

    public Event(@NotNull LocalDateTime dateStart, @NotNull LocalDateTime dateStop, @NotNull Employee employee) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.employee = employee;
    }

    @NotNull
    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(@NotNull LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    @NotNull
    public LocalDateTime getDateStop() {
        return dateStop;
    }

    public void setDateStop(@NotNull LocalDateTime dateStop) {
        this.dateStop = dateStop;
    }

    @NotNull
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NotNull Employee employee) {
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

