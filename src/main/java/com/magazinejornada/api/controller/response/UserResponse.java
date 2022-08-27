package com.magazinejornada.api.controller.response;

import com.magazinejornada.api.model.UserType;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private UserType userType;
    private String nome;
    private String email;
    private String fotoDePerfil;
    private String senha;

}
