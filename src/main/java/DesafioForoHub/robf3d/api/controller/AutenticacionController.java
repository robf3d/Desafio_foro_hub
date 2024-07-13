package DesafioForoHub.robf3d.api.controller;

import DesafioForoHub.robf3d.api.domain.usuarios.DatosAutenticacionUsuario;
import DesafioForoHub.robf3d.api.domain.usuarios.Usuario;
import DesafioForoHub.robf3d.api.infra.security.DatosJWTToken;
import DesafioForoHub.robf3d.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        var authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());
        var usuarioAuth = manager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAuth.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }

}
