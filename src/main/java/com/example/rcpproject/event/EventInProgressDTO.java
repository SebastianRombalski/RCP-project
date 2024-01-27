package com.example.rcpproject.event;

import com.example.rcpproject.employee.Employee;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventInProgressDTO {

    private LocalDateTime dateStart;
    private LocalDate dateWithoutTime;
    private LocalTime timeWithoutDate;
    private Employee employee;

    public EventInProgressDTO() {
    }

    public EventInProgressDTO(LocalDateTime dateStart, Employee employee) {
        this.dateStart = dateStart;
        this.employee = employee;
        this.dateWithoutTime = date(dateStart);
        this.timeWithoutDate = time(dateStart);
    }

    private LocalDate date(LocalDateTime dateStart) {
        return dateStart.toLocalDate();
    }

    private LocalTime time(LocalDateTime dateStart) {
        return dateStart.toLocalTime();
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDateWithoutTime() {
        return dateWithoutTime;
    }

    public void setDateWithoutTime(LocalDate dateWithoutTime) {
        this.dateWithoutTime = dateWithoutTime;
    }

    public LocalTime getTimeWithoutDate() {
        return timeWithoutDate;
    }

    public void setTimeWithoutDate(LocalTime timeWithoutDate) {
        this.timeWithoutDate = timeWithoutDate;
    }

    @Override
    public String toString() {
        return "EventInProgressDTO{" +
                "dateStart=" + dateStart +
                ", employee=" + employee +
                '}';
    }
}
