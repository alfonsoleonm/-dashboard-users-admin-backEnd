package com.sistema.examenes.exceptions;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException(){
        super("El usuario no existe!");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
