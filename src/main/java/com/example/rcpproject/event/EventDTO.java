package com.example.rcpproject.event;




import com.example.rcpproject.employee.Employee;

import java.time.Duration;
import java.time.LocalDateTime;


public class EventDTO {

    private LocalDateTime dateStart;
    private LocalDateTime dateStop;
    private TimeForEvenet timeInWork;
    private Employee employee;



    public EventDTO() {
    }

    public EventDTO(LocalDateTime dateStart, LocalDateTime dateStop, Employee employee) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.timeInWork = getTime(dateStart, dateStop);
        this.employee = employee;

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private TimeForEvenet getTime(LocalDateTime dateStart, LocalDateTime dateStop){
        TimeForEvenet timeForEvenet = new TimeForEvenet();
        int hours = (int)Duration.between(dateStart,dateStop).toHours();
        int minutes = (int)Duration.between(dateStart,dateStop).toMinutes();
        minutes = minutes - hours*60;
        timeForEvenet.setHours(hours);
        timeForEvenet.setMinutes(minutes);
        return timeForEvenet;
    }


    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateStop() {
        return dateStop;
    }

    public void setDateStop(LocalDateTime dateStop) {
        this.dateStop = dateStop;
    }

    public TimeForEvenet getTimeInWork() {
        return timeInWork;
    }

    public void setTimeInWork(TimeForEvenet timeInWork) {
        this.timeInWork = timeInWork;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "dateStart=" + dateStart +
                ", dateStop=" + dateStop +
                ", timeInWork=" + timeInWork +
                ", employee=" + employee +
                '}' + '\n';
    }
}
