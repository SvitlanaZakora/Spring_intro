package service;

import model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title);
    List<Event> getEventsForDay(LocalDate day);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    boolean deleteEvent(long eventId);

}
