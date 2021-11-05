package dev.smith.models;

import dev.smith.repositories.EventHBImpl;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void shouldGetEvent() {
        EventHBImpl er = new EventHBImpl();

        Event e1 = new Event(1);
        Event e2 = new Event();
        e2.setEventId(e1.getEventId());
        Event expected = er.getEvents(1);
        Event actual = e2;
    }
}
