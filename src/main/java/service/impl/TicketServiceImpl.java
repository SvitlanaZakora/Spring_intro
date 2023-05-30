package service.impl;

import model.Event;
import model.Ticket;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TicketRepository;
import service.TicketService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(long id, long userId, long eventId, String place, Ticket.Category category) {
        final Ticket ticket = Ticket.builder()
                .id(id)
                .userId(userId)
                .eventId(eventId)
                .place(place)
                .category(category)
                .build();

        return ticketRepository.addTicket(ticket);
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        final List<Ticket> newList = new ArrayList<>();

        for (Ticket t : ticketRepository.getAllTickets()) {
            if (t.getUserId() == user.getId()) {
                newList.add(t);
            }
        }
        return newList;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {

        final List<Ticket> newList = new ArrayList<>();

        for (Ticket t : ticketRepository.getAllTickets()) {
            if (t.getEventId() == event.getId()) {
                newList.add(t);
            }
        }
        return newList;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketRepository.deleteTicket(valueOf(ticketId));
    }
}
