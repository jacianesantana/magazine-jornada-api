package com.magazinejornada.api.adapter;

import com.magazinejornada.api.controller.request.UserRequest;
import com.magazinejornada.api.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .userType(userRequest.getUserType())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .profilePicture(userRequest.getProfilePicture())
                .password(userRequest.getPassword())
                .build();
    }

}
