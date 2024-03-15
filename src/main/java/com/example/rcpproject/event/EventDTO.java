package com.example.rcpproject.event;




import com.example.rcpproject.employee.Employee;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.lang.NonNull;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class EventDTO {

    @NonNull
    @PastOrPresent
    private LocalDateTime dateStart;
    @NonNull
    @PastOrPresent
    private LocalDateTime dateStop;
    private TimeForEvenet timeInWork;
    @NonNull
    private Employee employee;

    private LocalDate dateStartWithoutTime;
    private LocalTime timeStartWithoutDate;
    private LocalDate dateStopWithoutTime;
    private LocalTime timeStopWithoutDate;

    private Long id;



    public EventDTO() {
    }

    public EventDTO(@NonNull LocalDateTime dateStart, @NonNull LocalDateTime dateStop, @NonNull Employee employee) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.timeInWork = getTime(dateStart, dateStop);
        this.employee = employee;
        this.dateStartWithoutTime = time(dateStart);
        this.timeStartWithoutDate = date(dateStart);
        this.dateStopWithoutTime = time(dateStop);
        this.timeStopWithoutDate = date(dateStop);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private LocalTime date(LocalDateTime date) {
        return date.toLocalTime();
    }

    private LocalDate time(LocalDateTime date) {
        return date.toLocalDate();
    }
    @NonNull
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NonNull Employee employee) {
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

    public TimeForEvenet getTimeInWork() {
        return timeInWork;
    }

    public void setTimeInWork(TimeForEvenet timeInWork) {
        this.timeInWork = timeInWork;
    }

    public LocalDate getDateStartWithoutTime() {
        return dateStartWithoutTime;
    }

    public void setDateStartWithoutTime(LocalDate dateStartWithoutTime) {
        this.dateStartWithoutTime = dateStartWithoutTime;
    }

    public LocalTime getTimeStartWithoutDate() {
        return timeStartWithoutDate;
    }

    public void setTimeStartWithoutDate(LocalTime timeStartWithoutDate) {
        this.timeStartWithoutDate = timeStartWithoutDate;
    }

    public LocalDate getDateStopWithoutTime() {
        return dateStopWithoutTime;
    }

    public void setDateStopWithoutTime(LocalDate dateStopWithoutTime) {
        this.dateStopWithoutTime = dateStopWithoutTime;
    }

    public LocalTime getTimeStopWithoutDate() {
        return timeStopWithoutDate;
    }

    public void setTimeStopWithoutDate(LocalTime timeStopWithoutDate) {
        this.timeStopWithoutDate = timeStopWithoutDate;
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
