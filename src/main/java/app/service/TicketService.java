package app.service;

import app.model.Event;
import app.model.Ticket;
import app.model.User;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(long id, long userId, long eventId, String place, Ticket.Category category);
    List<Ticket> getBookedTickets(User user);
    List<Ticket> getBookedTickets(Event event);
    boolean cancelTicket(long ticketId);
}
