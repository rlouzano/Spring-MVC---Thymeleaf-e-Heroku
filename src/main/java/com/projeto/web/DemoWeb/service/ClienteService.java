package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> PegaTodos(){
        return clienteRepository.findAll();
    }

    public Cliente Cadastrar(Cliente cliente){return clienteRepository.save(cliente); }

    public Cliente Update(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente BuscaUm(Integer id){
        return clienteRepository.getOne(id);
    }

    public void Remove(Cliente cliente){
        clienteRepository.delete(cliente);
    }

}
