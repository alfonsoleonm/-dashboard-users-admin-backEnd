package com.sistema.examenes.repositories;

import com.sistema.examenes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
