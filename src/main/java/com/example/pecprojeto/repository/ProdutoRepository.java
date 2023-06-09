package com.example.pecprojeto.repository;

import com.example.pecprojeto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    /*Repositórios declarados para suas respectivas identificações*/
}
