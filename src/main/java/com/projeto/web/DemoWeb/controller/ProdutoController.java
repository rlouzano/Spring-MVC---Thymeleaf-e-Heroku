package com.projeto.web.DemoWeb.controller;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.service.serviceImpl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    /**
     * Listar os produto na tela com thymeleaf
     */
    @GetMapping(value = "/listar")
    public String listar(@Validated Model model, Produto produto) {
        List<Produto> prod = produtoService.PegaTodos();
        model.addAttribute("prod", prod);
        return "produto/listar";
    }

    /**
     * Buscar os formulário de cadastro de produto
     *
     * @return
     */
    @GetMapping(value = "/cadastro")
    public String BuscaCadastro(Model model) {
        model.addAttribute("prod", new Produto());
        return "/produto/cadastro";
    }

    /**
     * Cadastro de produto no banco de dados
     */
    @PostMapping
    public String cadastrar(Produto produto) {
        this.produtoService.Cadastrar(produto);
        return "redirect:/produto/listar";
    }

    /**
     * Buscando dados por ID para realializar a edição do produto
     */
    @GetMapping("/{id}")
    public String BuscaEditar(@PathVariable("id") Integer id, Model model, Produto produto) {
        model.addAttribute("produto", this.produtoService.BuscaUm(id));
        return "/produto/editar";
    }

    /**
     * Realizando a edição do produto
     */
    @PutMapping("/{id}")
    public String edit(@PathVariable("id") Integer id, Produto produto) {
        this.produtoService.Update(id, produto);
        return "redirect:/produto/listar";
    }

    /**
     * Deletando um produto por ID
     */
    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Integer id, Produto produto) {
        this.produtoService.Remove(produto);
        return "redirect:/produto/listar";
    }


}
