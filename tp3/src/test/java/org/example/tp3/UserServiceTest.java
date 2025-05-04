package org.example.tp3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById() {
        User mockUser = new User(1L, "bouchemal");
        when(userRepository.findUserById(1L)).thenReturn(mockUser);

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("bouchemal", result.getName());
        assertEquals(1L, result.getId());

        verify(userRepository).findUserById(1L);
        verifyNoMoreInteractions(userRepository);
    }
}
