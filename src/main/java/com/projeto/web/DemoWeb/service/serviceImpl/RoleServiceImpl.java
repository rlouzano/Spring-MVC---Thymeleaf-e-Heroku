package com.projeto.web.DemoWeb.service.serviceImpl;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.domain.Role;
import com.projeto.web.DemoWeb.respository.ProdutoRepository;
import com.projeto.web.DemoWeb.respository.RoleRepository;
import com.projeto.web.DemoWeb.service.ProdutoService;
import com.projeto.web.DemoWeb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> PegaTodos() {
        return roleRepository.findAll();
    }

    @Override
    public Role Cadastrar(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean Update(Integer id, Role role) {
        Role r = findById(id);
        if (r != null) {
            r.setId(role.getId());
            r.setRoles(role.getRoles());
            this.roleRepository.save(role);
            return true;
        }
        return false;
    }

    private Role findById(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public Role BuscaUm(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public void Remove(Role role) {
        roleRepository.delete(role);
    }

}
