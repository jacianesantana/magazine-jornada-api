package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.UserAdapter;
import com.magazinejornada.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserAdapter userAdapter;

    @Test
    void saveSuccess() {
    }

}