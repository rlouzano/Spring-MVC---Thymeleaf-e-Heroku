package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Endereco;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import com.projeto.web.DemoWeb.respository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EnderecoService {

    public List<Endereco> PegaTodos();

    public Endereco Cadastrar(Endereco endereco);

    public Endereco Update(Endereco endereco);

    public Endereco BuscaUm(Integer id);
}
