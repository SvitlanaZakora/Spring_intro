package app.repository;

import app.model.Ticket;

import java.util.List;
import java.util.Map;

public interface TicketRepository {

    Ticket addTicket(final Ticket ticket);
    Ticket getTicket(final String id);
    boolean deleteTicket(final String id);
    List<Ticket> getAllTickets();
    void setTickets(Map<String, Ticket> tickets);
}
