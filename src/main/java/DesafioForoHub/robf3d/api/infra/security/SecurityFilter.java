package DesafioForoHub.robf3d.api.infra.security;
import DesafioForoHub.robf3d.api.domain.usuarios.Usuario;
import DesafioForoHub.robf3d.api.domain.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authToken = request.getHeader("Authorization");
        if(authToken != null){
            var token = authToken.replace("Bearer ","");
            var subject = tokenService.getSubject(token);
            System.out.println(token);
            if(subject != null){
                var usuario = usuarioRepository.findBylogin(subject);
                var auth = new UsernamePasswordAuthenticationToken(usuario,null,
                        usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request,response);
    }
}
