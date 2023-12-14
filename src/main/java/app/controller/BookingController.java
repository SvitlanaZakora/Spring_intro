package app.controller;

import app.facade.BookingFacade;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingFacade bookingFacade;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return bookingFacade.createUser(user);
    }
}
