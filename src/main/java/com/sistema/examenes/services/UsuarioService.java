package com.sistema.examenes.services;

import com.sistema.examenes.models.Usuario;
import com.sistema.examenes.models.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    public Usuario obtenerUSuario(String username);
    public void eliminarUsuario(Long usuarioId);
}
