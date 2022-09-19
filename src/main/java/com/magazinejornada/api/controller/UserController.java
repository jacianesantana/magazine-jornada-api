package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.LoginRequest;
import com.magazinejornada.api.controller.request.UserRequest;
import com.magazinejornada.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("user")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRequest userRequest) {
        userService.save(userRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

}
