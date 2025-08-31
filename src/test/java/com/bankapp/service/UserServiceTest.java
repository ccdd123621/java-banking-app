package com.bankapp.service;

import com.bankapp.model.User;
import com.bankapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByUsername() {
        User mockUser = new User();
        mockUser.setUsername("john");
        when(userRepository.findByUsername("john")).thenReturn(Optional.of(mockUser));

        Optional<User> found = userService.findByUsername("john");
        assertEquals("john", found.get().getUsername());
    }
}
