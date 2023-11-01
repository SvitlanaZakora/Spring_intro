package app.service;

import app.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    Event getEventById(long eventId);
    List<Event> getEventsByTitle(String title);
    List<Event> getEventsForDay(LocalDate day);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    List<Event> getAllEvents();
    boolean deleteEvent(long eventId);

}
