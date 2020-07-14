package com.projeto.web.DemoWeb.service.serviceImpl;

import com.projeto.web.DemoWeb.domain.Endereco;
import com.projeto.web.DemoWeb.respository.EnderecoRepository;
import com.projeto.web.DemoWeb.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> PegaTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco Cadastrar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco Update(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco BuscaUm(Integer id) {
        return enderecoRepository.getOne(id);
    }
}
