package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.UserAdapter;
import com.magazinejornada.api.controller.request.LoginRequest;
import com.magazinejornada.api.controller.request.UserRequest;
import com.magazinejornada.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAdapter userAdapter;

    public void save(UserRequest userRequest) {
        var user = userAdapter.toUser(userRequest);
        userRepository.save(user);
    }

    public boolean login(LoginRequest loginRequest) {
        var user = userRepository.findByEmail(loginRequest.getEmail());
        return user.getEmail().equals(loginRequest.getEmail()) && user.getPassword().equals(loginRequest.getPassword());
    }

}
