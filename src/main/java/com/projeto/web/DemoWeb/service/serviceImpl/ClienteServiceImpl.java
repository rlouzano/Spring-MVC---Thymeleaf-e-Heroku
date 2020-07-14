package com.projeto.web.DemoWeb.service.serviceImpl;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import com.projeto.web.DemoWeb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> PegaTodos(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente Cadastrar(Cliente cliente){return clienteRepository.save(cliente); }

    @Override
    public Cliente Update(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente BuscaUm(Integer id){
        return clienteRepository.getOne(id);
    }

    @Override
    public void Remove(Cliente cliente){
        clienteRepository.delete(cliente);
    }

}
