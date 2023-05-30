package repository;

import model.Ticket;
import model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    User addUser(final User user);
    User getUser(final String id);
    User getUserByEmail(final String email);
    User updateUser(final User user);
    List<User> getUsersByName(final String name);
    boolean deleteUser(final String id);
    List<User> getAllUsers();
    void setUsers(Map<String, User> users);
}
