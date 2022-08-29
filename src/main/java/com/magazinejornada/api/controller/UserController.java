package com.magazinejornada.api.controller;

import com.magazinejornada.api.adapter.UserAdapter;
import com.magazinejornada.api.controller.request.UserRequest;
import com.magazinejornada.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("magazinejornada")
public class UserController {

    private final UserService userService;
    private final UserAdapter userAdapter;

    @PostMapping("/register-user")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        userService.save(userRequest);
        var user = userAdapter.toUser(userRequest);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
