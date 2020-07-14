package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Usuario;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import com.projeto.web.DemoWeb.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> PegaTodos();

    public Usuario cadastrar(Usuario usuario);

    public boolean Update(Integer id, Usuario usuario);

    public Usuario BuscaUm(Integer id);

    public Usuario BuscaLogin(String username);

    public void Remove(Usuario usuario);
}
