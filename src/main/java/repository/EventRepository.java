package repository;

import model.Event;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EventRepository {

    Event addEvent(final Event event);
    Event getEvent(final String id);
    Event updateEvent(final Event event);
    List<Event> getEventsByTitle(final String title);
    List<Event> getEventsForDay(final LocalDate day);
    boolean deleteEvent(final String id);
    void setEvents(Map<String, Event> events);
}
