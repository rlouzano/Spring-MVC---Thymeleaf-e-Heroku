package com.projeto.web.DemoWeb.controller;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Endereco;
import com.projeto.web.DemoWeb.respository.ClienteRepository;
import com.projeto.web.DemoWeb.service.ClienteService;
import com.projeto.web.DemoWeb.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ModelAndView ListarTodos(Cliente cliente, Endereco endereco) {
        ModelAndView mv = new ModelAndView("lista");
        endereco.setCliente(cliente);
        List<Endereco> c = enderecoService.PegaTodos();
        mv.addObject("cliente", c);
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String CadCliente() {
        return "/cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String CadastroCliente(Endereco endereco, Cliente cliente) {
        ModelAndView mv = new ModelAndView("lista");
        endereco.setCliente(cliente);
        clienteService.Cadastrar(cliente);
        enderecoService.Cadastrar(endereco);
        return "redirect:/cliente/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView BuscaUpdate(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("editar");
        mv.addObject("cliente", clienteService.BuscaUm(id));
        return mv;
    }

    @PostMapping(value = "{id}")
    public ModelAndView update(@PathVariable("id") Integer id, @ModelAttribute("cliente") Cliente cliente) {
        ModelAndView mv = new ModelAndView("redirect:/cliente/listar");
        Cliente findCliente = clienteService.BuscaUm(id);
        if (findCliente != null) {
            findCliente.setId(cliente.getId());
            findCliente.setNome(cliente.getNome());
            findCliente.setCpf(cliente.getCpf());
            findCliente.setRg(cliente.getRg());
            findCliente.setCargo(cliente.getCargo());
            clienteService.Cadastrar(cliente);
            return mv;
        }
        return mv;
    }

    @PostMapping(value = "/excluir/{id}")
    public String remove(@PathVariable("id") Integer id) {
        Cliente cli = clienteService.BuscaUm(id);
        if (cli != null) {
            clienteService.Remove(cli);
            return "redirect:/cliente/listar";
        }
        return "redirect:/cliente/listar";
    }
}
