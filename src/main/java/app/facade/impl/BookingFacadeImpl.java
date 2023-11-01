package app.facade.impl;

import app.facade.BookingFacade;
import app.model.Event;
import app.model.Ticket;
import app.model.User;
import app.service.EventService;
import app.service.TicketService;
import app.service.UserService;
import app.service.impl.PreloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    private final TicketService ticketService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final EventService eventService;
    @Autowired
    private final PreloadService preloadService;

    public BookingFacadeImpl(final TicketService ticketService, final UserService userService,
                             final EventService eventService, PreloadService preloadService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.eventService = eventService;
        this.preloadService = preloadService;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title) {
        return eventService.getEventsByTitle(title);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Override
    public List<Event> getEventsForDay(LocalDate day) {
        return eventService.getEventsForDay(day);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userService.getUsersByName(name);
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long id, long userId, long eventId, String place, Ticket.Category category) {
        return ticketService.bookTicket(id, userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {

        return ticketService.getBookedTickets(user);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {

        return ticketService.getBookedTickets(event);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }

    @Override
    public void preloadTickets() throws IOException {
        preloadService.preloadTickets();
    }
}
