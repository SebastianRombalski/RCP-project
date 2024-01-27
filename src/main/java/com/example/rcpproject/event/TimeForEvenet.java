package com.example.rcpproject.event;

public class TimeForEvenet {

    private int hours;
    private int minutes;

    public TimeForEvenet(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeForEvenet() {
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "TimeForEvenet{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
