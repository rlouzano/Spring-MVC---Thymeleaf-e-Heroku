package com.projeto.web.DemoWeb.service.serviceImpl;

import com.projeto.web.DemoWeb.domain.Role;
import com.projeto.web.DemoWeb.domain.Usuario;
import com.projeto.web.DemoWeb.respository.RoleRepository;
import com.projeto.web.DemoWeb.respository.UsuarioRepository;
import com.projeto.web.DemoWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Usuario> PegaTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario cadastrar(Usuario usuario) {
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Role userRole = this.roleRepository.findByRoles("USER");
        usuario.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public boolean Update(Integer id, Usuario usuario) {
        Usuario user = findById(id);
        if (user != null) {
            user.setId(usuario.getId());
            user.setNome(usuario.getNome());
            user.setSobrenome(usuario.getSobrenome());
            user.setUsername(usuario.getUsername());
            user.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
            this.usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    private Usuario findById(Integer id) {
        return usuarioRepository.getOne(id);
    }

    @Override
    public Usuario BuscaUm(Integer id) {
        return usuarioRepository.getOne(id);
    }

    @Override
    public Usuario BuscaLogin(String username) {
        return null;
    }

    /*@Override
    public Usuario BuscaLogin(String username) {
        return this.usuarioRepository.findByUsername(username);
    }*/

    @Override
    public void Remove(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}
