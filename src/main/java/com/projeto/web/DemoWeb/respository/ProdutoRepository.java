package com.projeto.web.DemoWeb.respository;

import com.projeto.web.DemoWeb.domain.Produto;
import com.projeto.web.DemoWeb.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
