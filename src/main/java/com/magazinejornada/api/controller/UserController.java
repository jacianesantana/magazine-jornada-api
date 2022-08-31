package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.UserRequest;
import com.magazinejornada.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("magazinejornada")
public class UserController {

    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRequest userRequest) {
        userService.save(userRequest);
        return ResponseEntity.ok().build();
    }

}
