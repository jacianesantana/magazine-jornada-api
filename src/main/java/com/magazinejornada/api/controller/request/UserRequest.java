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
    private String nome;
    @Email
    private String email;
    private String fotoDePerfil;
    private String senha;

}
