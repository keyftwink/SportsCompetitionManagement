package com.example.sportsCompetitionManagement;


import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SportEventAddTest {

    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
    }


    @Test
    public void getEventId() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals(1, event.getEventId());
    }
    @Test
    public void getName() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("соревнование1", event.getName());
    }
    @Test
    public void getLocation() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("место1", event.getLocation());
    }
    @Test
    public void getDate() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("2023", event.getDate());
    }
}