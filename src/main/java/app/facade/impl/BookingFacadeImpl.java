package app.facade.impl;

import app.facade.BookingFacade;
import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingFacadeImpl implements BookingFacade {

    @Autowired
    private final UserService userService;

    public BookingFacadeImpl(final UserService userService
    ) {
        this.userService = userService;
    }

    @Override
    public Optional<User> getUserById(long userId) {
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
    public void deleteUser(long userId) {
        userService.deleteUser(userId);
    }
}
