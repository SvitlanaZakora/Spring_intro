package app.service;

import app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> getUserById(long userId);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    User createUser(User user);
    void deleteUser(long userId);
}
