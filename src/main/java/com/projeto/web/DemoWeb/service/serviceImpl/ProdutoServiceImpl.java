package com.projeto.web.DemoWeb.service.serviceImpl;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.respository.ProdutoRepository;
import com.projeto.web.DemoWeb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> PegaTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto Cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public boolean Update(Integer id, Produto produto) {
        Produto prod = findById(id);
        if (prod != null) {
            prod.setId(produto.getId());
            prod.setNome(produto.getNome());
            prod.setDescricao(produto.getDescricao());
            prod.setValor(produto.getValor());
            prod.setData_criacao(produto.getData_criacao());
            this.produtoRepository.save(produto);
            return true;
        }
        return false;
    }

    private Produto findById(Integer id) {
        return produtoRepository.getOne(id);
    }

    @Override
    public Produto BuscaUm(Integer id) {
        return produtoRepository.getOne(id);
    }

    @Override
    public void Remove(Produto produto) {
        produtoRepository.delete(produto);
    }

}
