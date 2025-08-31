package com.bankapp.controller;

import com.bankapp.model.User;
import com.bankapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListUsers() {
        when(userService.findAll()).thenReturn(Arrays.asList(new User(), new User()));
        String view = userController.listUsers(model);
        verify(model, times(1)).addAttribute(eq("users"), any());
        assertEquals("userList", view);
    }
}
