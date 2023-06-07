package com.example.sportsCompetitionManagement;

import java.time.LocalDateTime;
import java.util.Date;

public class SportEvent {

    private int eventId;
    private String name;
    private String location;
    private String date;

    public SportEvent(int eventId, String name, String location, String date) {
        this.eventId = eventId;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public SportEvent() {

    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
