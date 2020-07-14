package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService { //implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    public CustomUserDetailService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = Optional.ofNullable(usuarioService.BuscaLogin(username))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não pode ser nullo"));
      //  List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
       // List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(),usuario.getPassword());
        //, usuario.getRoles() ? authorityListAdmin : authorityListUser
    }

 */
}
