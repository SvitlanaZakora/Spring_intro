package app.service.impl;

import app.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.EventRepository;
import app.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.lang.String.valueOf;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getEventById(long eventId) {
        return eventRepository.getEvent(valueOf(eventId));
    }

    @Override
    public List<Event> getEventsByTitle(String title) {
        return eventRepository.getEventsByTitle(title);
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day) {
        return eventRepository.getEventsForDay(day);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.addEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.updateEvent(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventRepository.deleteEvent(valueOf(eventId));
    }
}
