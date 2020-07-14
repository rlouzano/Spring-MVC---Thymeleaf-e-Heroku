package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.domain.Usuario;
import com.projeto.web.DemoWeb.respository.ProdutoRepository;
import com.projeto.web.DemoWeb.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProdutoService {

    public List<Produto> PegaTodos();

    public Produto Cadastrar(Produto produto);

    public boolean Update(Integer id, Produto produto);

    public Produto BuscaUm(Integer id);

    public void Remove(Produto produto);
}
