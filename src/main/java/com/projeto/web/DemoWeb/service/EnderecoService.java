package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Endereco;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import com.projeto.web.DemoWeb.respository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> PegaTodos(){
        return enderecoRepository.findAll();
    }
    public Endereco Cadastrar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco Update(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    public Endereco BuscaUm(Integer id){
        return enderecoRepository.getOne(id);
    }
}
