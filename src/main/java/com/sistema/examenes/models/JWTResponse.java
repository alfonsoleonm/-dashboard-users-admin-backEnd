package com.sistema.examenes.models;

import lombok.Getter;
import lombok.Setter;

public class JWTResponse {
    @Getter @Setter
    private String token;

    public JWTResponse(String token){
        this.token = token;
    }

    public JWTResponse(){}




}
