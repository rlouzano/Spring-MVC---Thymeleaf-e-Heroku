package com.projeto.web.DemoWeb.service;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> PegaTodos();

    public Role Cadastrar(Role role);

    public boolean Update(Integer id, Role role);

    public Role BuscaUm(Integer id);

    public void Remove(Role role);
}
