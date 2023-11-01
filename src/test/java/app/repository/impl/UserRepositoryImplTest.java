package app.repository.impl;

import app.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryImplTest {
    private static final long ID_1 = 1;
    private static final long ID_2 = 2;
    private static final String NAME = "John";
    private static final String EMAIL = "john@email.com";
    public static final String NEW_NAME = "Joe";

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void init() {
        Map<String, User> map = new HashMap<>();
        map.put(valueOf(ID_1), buildUser(ID_1));
        userRepository.setUsers(map);
    }

    @Test
    void testCreateUser() {
        final User user = buildUser(ID_2);

        final User res = userRepository.addUser(user);

        assertNotNull(res);
        assertEquals(ID_2, res.getId());
    }

    @Test
    void testGetUserById() {
        final User res = userRepository.getUser(valueOf(ID_1));

        assertNotNull(res);
    }

    @Test
    void testGetUserByEmail() {
        final User res = userRepository.getUserByEmail(EMAIL);

        assertNotNull(res);
        assertEquals(EMAIL, res.getEmail());
    }

    @Test
    void testGetUsersByName() {
        final List<User> res = userRepository.getUsersByName(NAME);

        assertNotNull(res.get(0));
        assertEquals(NAME, res.get(0).getName());
    }

    @Test
    void testUpdateUser() {
        final User newUser = buildUser(ID_1);
        newUser.setName(NEW_NAME);

        final User res = userRepository.updateUser(newUser);

        assertNotNull(res);
        assertEquals(NEW_NAME, res.getName());
    }

    @Test
    void testDeleteUser() {
        final boolean res = userRepository.deleteUser(valueOf(ID_1));

        assertTrue(res);
    }

    private User buildUser(final long id) {
        return User.builder()
                .id(id)
                .name(NAME)
                .email(EMAIL)
                .build();
    }
}
