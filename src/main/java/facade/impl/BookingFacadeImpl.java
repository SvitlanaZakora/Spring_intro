package facade.impl;

import facade.BookingFacade;
import model.Event;
import model.Ticket;
import model.User;
import service.EventService;
import service.TicketService;
import service.UserService;

import java.time.LocalDate;
import java.util.List;

public class BookingFacadeImpl implements BookingFacade {

    private final TicketService ticketService;
    private final UserService userService;
    private final EventService eventService;

    public BookingFacadeImpl(final TicketService ticketService, final UserService userService,
                             final EventService eventService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.eventService = eventService;
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
}
