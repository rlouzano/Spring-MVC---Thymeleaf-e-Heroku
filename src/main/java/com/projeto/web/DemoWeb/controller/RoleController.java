package com.projeto.web.DemoWeb.controller;

import com.projeto.web.DemoWeb.domain.Role;
import com.projeto.web.DemoWeb.respository.RoleRepository;
import com.projeto.web.DemoWeb.service.serviceImpl.RoleServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;


    @GetMapping("/listar")
    public String listar(Role role, Model model){
        model.addAttribute("list",roleService.PegaTodos());
        return "/role/listar";
    }

    @GetMapping("/cadastro")
    public String cadRoles(Model model){
        model.addAttribute("role", new Role());
        return "/role/cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastro(Role role){
        this.roleService.Cadastrar(role);
        return "redirect:/roles/listar";
    }
}
