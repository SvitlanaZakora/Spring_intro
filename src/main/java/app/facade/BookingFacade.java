package app.facade;

import app.model.Event;
import app.model.Ticket;
import app.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Groups together all operations related to tickets booking.
 * Created by maksym_govorischev.
 */
@Service
public interface BookingFacade {

    /**
     * Gets user by its id.
     * @return User.
     */
    Optional<User> getUserById(long userId);

    /**
     * Gets user by its email. Email is strictly matched.
     * @return User.
     */
    User getUserByEmail(String email);

    /**
     * Get list of users by matching name. Name is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     * @param name Users name or it's part.
     * @return List of users.
     */
    List<User> getUsersByName(String name);

    /**
     * Creates new user. User id should be auto-generated.
     * @param user User data.
     * @return Created User object.
     */
    User createUser(User user);

    /**
     * Deletes user by its id.
     * @param userId User id.
     */
    void deleteUser(long userId);

}
