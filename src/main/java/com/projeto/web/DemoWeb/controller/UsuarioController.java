package com.projeto.web.DemoWeb.controller;

import com.projeto.web.DemoWeb.domain.Usuario;
import com.projeto.web.DemoWeb.service.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String index(Model model, Usuario usuario) {
        model.addAttribute("list", usuarioService.PegaTodos());
        return "usuario/listar";
    }

    @GetMapping("/cadastro")
    public String buscaCadastro(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/cadastro";
    }

    @PostMapping
    public String cadastro(@Validated @ModelAttribute("user")  Usuario usuario, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "usuario/listar";
        }
        this.usuarioService.cadastrar(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Integer id, @Validated Model model) {
        Usuario user = usuarioService.BuscaUm(id);
        model.addAttribute("edit", user);
        return "usuario/editar";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("edit")  Usuario usuario, Model model) {
        this.usuarioService.Update(id, usuario);
        return "redirect:/usuario/listar";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Integer id, Model model, Usuario usuario){
        this.usuarioService.Remove(usuario);
        return "redirect:/usuario/listar";
    }

}
