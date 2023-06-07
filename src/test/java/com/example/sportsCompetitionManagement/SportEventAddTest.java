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
    public void getBookName() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals(1, event.getEventId());
    }
    @Test
    public void getBookAuthor() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("соревнование1", event.getName());
    }
    @Test
    public void getBookGenre() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("место1", event.getLocation());
    }
    @Test
    public void getBookPresence() {
        SportEvent event = new SportEvent(1,"соревнование1","место1","2023");
        assertEquals("2023", event.getDate());
    }
}