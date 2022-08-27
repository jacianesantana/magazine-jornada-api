package com.magazinejornada.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserType userType;
    private String nome;
    @Email
    private String email;
    private String fotoDePerfil;
    private String senha;

}
