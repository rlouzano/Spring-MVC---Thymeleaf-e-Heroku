package com.projeto.web.DemoWeb.controller;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Endereco;
import com.projeto.web.DemoWeb.service.serviceImpl.ClienteServiceImpl;
import com.projeto.web.DemoWeb.service.serviceImpl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ModelAndView ListarTodos(Cliente cliente, Endereco endereco) {
        ModelAndView mv = new ModelAndView("cliente/lista");
        endereco.setCliente(cliente);
        List<Endereco> c = enderecoService.PegaTodos();
        mv.addObject("cliente", c);
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String CadCliente() {
        return "cliente/cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String CadastroCliente(Endereco endereco, Cliente cliente) {
       // ModelAndView mv = new ModelAndView("cliente/listar");
        endereco.setCliente(cliente);
        clienteService.Cadastrar(cliente);
        enderecoService.Cadastrar(endereco);
        return "redirect:/cliente/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView BuscaUpdate(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("cliente/editar");
        mv.addObject("cliente", clienteService.BuscaUm(id));
        return mv;
    }

    @PutMapping(value = "{id}")
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

    @DeleteMapping(value = "/excluir/{id}")
    public String remove(@PathVariable("id") Integer id) {
        Cliente cli = clienteService.BuscaUm(id);
        if (cli != null) {
            clienteService.Remove(cli);
            return "redirect:/cliente/listar";
        }
        return "redirect:/cliente/listar";
    }
}
