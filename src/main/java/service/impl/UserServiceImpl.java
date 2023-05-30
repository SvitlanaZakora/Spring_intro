package service.impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;
import service.UserService;

import java.util.List;

import static java.lang.String.valueOf;

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
