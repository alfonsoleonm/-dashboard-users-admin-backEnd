package com.sistema.examenes.models;

import lombok.Getter;
import lombok.Setter;

public class JWTRequest {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public JWTRequest(){

    }

    public JWTRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
