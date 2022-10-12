package com.sistema.examenes;

import com.sistema.examenes.exceptions.UsuarioFoundException;
import com.sistema.examenes.models.Rol;
import com.sistema.examenes.models.Usuario;
import com.sistema.examenes.models.UsuarioRol;
import com.sistema.examenes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		/*try{
			Usuario usuario = new Usuario();
			usuario.setNombre("Alfonso");
			usuario.setApellido("Leon");
			usuario.setUsername("alfonsolen");
			usuario.setPassword(this.bCryptPasswordEncoder.encode("alfonsolen"));
			usuario.setEmail("aleon1@gmail.com");
			usuario.setTelefono("123124124");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setNombre("ADMIN");

			//relacionar estos 2
			Set<UsuarioRol> usuarioRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());
		} catch (Exception e){
			e.printStackTrace();
		}*/
	}
}
