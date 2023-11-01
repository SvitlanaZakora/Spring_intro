package app.controller;

import app.facade.BookingFacade;
import app.model.Report;
import app.model.Ticket;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookedTicketsController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/getBookedTickets/{userId}")
    public String getBookedTickets(@PathVariable(value = "userId") long userId, Model model) {
        User user = bookingFacade.getUserById(userId);
        List<Ticket> bookedTickets = bookingFacade.getBookedTickets(user);
        model.addAttribute("allbookedtickets", bookedTickets);
        return "bookedtickets";
    }


    @GetMapping("/updateTicketsFromXml/{userId}")
    public String updateTicketsFromXml(@PathVariable(value = "userId") long userId, Model model) throws IOException {
        User user = bookingFacade.getUserById(userId);
        bookingFacade.preloadTickets();
        List<Ticket> bookedTickets = bookingFacade.getBookedTickets(user);
        model.addAttribute("allbookedtickets", bookedTickets);
        return "bookedtickets";
    }

    @GetMapping("/getBookedTicketsReport/{userId}")
    public String handleForexRequest(@PathVariable(value = "userId") long userId, Model model) {
        User user = bookingFacade.getUserById(userId);
        List<Ticket> bookedTickets = bookingFacade.getBookedTickets(user);
        model.addAttribute("report", getReport(bookedTickets));
        return "reportView";
    }

    private Report getReport(List<Ticket> bookedTickets) {
        Report report = new Report();
        List<Long> events = new ArrayList<>();
        List<Long> users = new ArrayList<>();
        List<String> categories = new ArrayList<>();
        List<String> places = new ArrayList<>();
        for (Ticket ticket : bookedTickets) {
            events.add(ticket.getEventId());
            users.add(ticket.getUserId());
            categories.add(ticket.getCategory().name());
            places.add(ticket.getPlace());
        }
        report.setEvents(events);
        report.setUsers(users);
        report.setCategories(categories);
        report.setPlaces(places);

        return report;
    }
}
