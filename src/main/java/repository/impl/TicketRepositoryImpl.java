package repository.impl;

import model.Ticket;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

public class TicketRepositoryImpl implements TicketRepository {

    private Map<String, Ticket> tickets;

    @Override
    public Ticket addTicket(Ticket ticket) {
        tickets.put(valueOf(ticket.getId()), ticket);
        return ticket;
    }

    @Override
    public Ticket getTicket(String id) {
        return tickets.get(id);
    }

    @Override
    public boolean deleteTicket(String id) {
        tickets.remove(id);

        return tickets.get(id) == null;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets.values());
    }

    @Override
    public void setTickets(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }
}
