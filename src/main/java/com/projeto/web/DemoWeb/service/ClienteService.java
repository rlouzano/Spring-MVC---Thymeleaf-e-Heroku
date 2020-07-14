package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente> PegaTodos();

    public Cliente Cadastrar(Cliente cliente);

    public Cliente Update(Cliente cliente);

    public Cliente BuscaUm(Integer id);

    public void Remove(Cliente cliente);

}
