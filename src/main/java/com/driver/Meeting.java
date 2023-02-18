package com.driver;

import java.time.LocalTime;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before or equal to end time.");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before or equal to end time.");
        }
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time must be after or equal to start time.");
        }
        this.endTime = endTime;
    }

    public boolean overlapsWith(Meeting otherMeeting) {
        return !(this.endTime.isBefore(otherMeeting.getStartTime()) || this.startTime.isAfter(otherMeeting.getEndTime()));
    }
}
