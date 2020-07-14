package com.projeto.web.DemoWeb.respository;

import com.projeto.web.DemoWeb.domain.Cliente;
import com.projeto.web.DemoWeb.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoles(String user);
}
