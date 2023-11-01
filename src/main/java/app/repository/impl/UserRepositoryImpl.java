package app.repository.impl;

import app.model.User;
import app.repository.UserRepository;
import app.util.Writter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users = Writter.usersFromTextFile();

    @Override
    public void setUsers(Map<String, User> users){
        this.users=users;
    }

    @Override
    public User addUser(User user) {
        users.put(valueOf(user.getId()), user);
        return user;
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        if (users.get(valueOf(user.getId())) != null) {
            users.put(valueOf(user.getId()), user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        List<User> namedUsers = new ArrayList<>();
        for (User u : users.values()) {
            if (u.getName().equals(name)) {
                namedUsers.add(u);
            }
        }

        return namedUsers;
    }

    @Override
    public boolean deleteUser(String id) {
        users.remove(id);

        return users.get(id) == null;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
