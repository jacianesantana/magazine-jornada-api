package com.magazinejornada.api.controller.request;

import com.magazinejornada.api.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private UserType userType;
    private String name;
    @Email
    private String email;
    private String profilePicture;
    private String password;

}
