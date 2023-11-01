package app.service.impl;

import app.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import app.repository.UserRepository;

import java.util.List;

import static java.lang.String.valueOf;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private static final long ID = 1;
    private static final String NAME = "John";
    private static final String EMAIL = "john@email.com";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        final User user = buildUser();
        given(userRepository.addUser(any())).willReturn(user);

        final User res = userService.createUser(any());

        assertEquals(user, res);
    }

    @Test
    void testGetUserById() {
        final User user = buildUser();
        given(userRepository.getUser(valueOf(ID))).willReturn(user);

        final User res = userService.getUserById(ID);

        assertEquals(user, res);
    }

    @Test
    void testGetUserByEmail() {
        final User user = buildUser();
        given(userRepository.getUserByEmail(EMAIL)).willReturn(user);

        final User res = userService.getUserByEmail(EMAIL);

        assertEquals(user, res);
    }

    @Test
    void testGetUsersByName() {
        final User user = buildUser();
        given(userRepository.getUsersByName(NAME)).willReturn(singletonList(user));

        final List<User> res = userService.getUsersByName(NAME);

        assertEquals(user, res.get(0));
    }

    @Test
    void testUpdateUser() {
        final User user = buildUser();
        given(userRepository.updateUser(any())).willReturn(user);

        final User res = userService.updateUser(any());

        assertEquals(user, res);
    }

    @Test
    void testDeleteUser() {
        given(userRepository.deleteUser(valueOf(ID))).willReturn(true);

        final boolean res = userService.deleteUser(ID);

        assertTrue(res);
    }

    private User buildUser() {
        return User.builder()
                .id(ID)
                .name(NAME)
                .email(EMAIL)
                .build();
    }
}
