package com.sistema.examenes.controllers;

import com.sistema.examenes.exceptions.UsuarioNotFoundException;
import com.sistema.examenes.models.JWTRequest;
import com.sistema.examenes.models.JWTResponse;
import com.sistema.examenes.models.Usuario;
import com.sistema.examenes.security.JwtUtils;
import com.sistema.examenes.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JWTRequest jwtRequest) throws Exception{
        try {
            autenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        }catch (Exception e) {
            e.printStackTrace();
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JWTResponse(token));
    }

    private void autenticar(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException disabledException){
            throw new Exception("USUARIO DESHABILITADO " + disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("CREDENCIALES INVALIDAS " + badCredentialsException.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}
