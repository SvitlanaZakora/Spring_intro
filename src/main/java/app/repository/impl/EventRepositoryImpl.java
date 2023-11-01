package app.repository.impl;

import app.model.Event;
import app.repository.EventRepository;
import app.util.Writter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

@Repository
public class EventRepositoryImpl implements EventRepository {
    private Map<String, Event> events = Writter.eventsFromTextFile();

    @Override
    public void setEvents(Map<String, Event> events){
        this.events=events;
    }

    @Override
    public Event addEvent(Event event) {
        events.put(valueOf(event.getId()), event);
        return event;
    }

    @Override
    public Event getEvent(String id) {
        return events.get(id);
    }

    @Override
    public Event updateEvent(Event event) {
        if (events.get(valueOf(event.getId())) != null) {
            events.put(valueOf(event.getId()), event);
            return event;
        }
        return null;
    }

    @Override
    public List<Event> getAllEvents() {

        return new ArrayList<>(events.values());
    }

    @Override
    public List<Event> getEventsByTitle(String title) {
        List<Event> titledEvents = new ArrayList<>();
        for (Event e : events.values()) {
            if (e.getTitle().equals(title)) {
                titledEvents.add(e);
            }
        }

        return titledEvents;
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day) {
        List<Event> datedEvents = new ArrayList<>();
        for (Event e : events.values()) {
            if (e.getDate().equals(day)) {
                datedEvents.add(e);
            }
        }

        return datedEvents;
    }

    @Override
    public boolean deleteEvent(String id) {
        events.remove(id);

        return events.get(id) == null;
    }
}
