package app.service.impl;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.UserRepository;
import app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.valueOf;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long userId) {
        return userRepository.getUser(valueOf(userId));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.getUsersByName(name);
    }

    @Override
    public User createUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userRepository.deleteUser(valueOf(userId));
    }
}
