package app.controller;

import app.facade.BookingFacade;
import app.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/getAllEvents/{title}")
    public String getEventsByTitle(@PathVariable(value = "title") String title, Model model) {
        System.out.println(title);
        List<Event> events = bookingFacade.getEventsByTitle(title);
        model.addAttribute("allevents", events);
        return "index";
    }

    @GetMapping("/getAllEvents")
    public String getAllEvents(Model model) {
        List<Event> events = bookingFacade.getAllEvents();
        model.addAttribute("allevents", events);
        return "index";
    }

    @GetMapping("/updateEvent/{id}")
    public String updateForm(@PathVariable(value = "id") long id,
                                   Model model) {
        Event event = bookingFacade.getEventById(id);
        model.addAttribute("event", event);
        return "update";
    }

    @PostMapping("/update")
    public String updateEvent(@ModelAttribute("event") Event event) {
        bookingFacade.updateEvent(event);
        return "redirect:/getAllEvents";
    }

    @GetMapping("/addNewEvent")
    public String addNewEvent(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "newevent";
    }

    @PostMapping("/createEvent")
    public String createEvent(@ModelAttribute("event") Event event) {
        bookingFacade.createEvent(event);
        return "redirect:/getAllEvents";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") long id) {
        bookingFacade.deleteEvent(id);
        return "redirect:/getAllEvents";
    }
}
