package com.example.pecprojeto.repository;

import com.example.pecprojeto.entity.Item_Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Item_PedidoRepository extends JpaRepository<Item_Pedido, Integer> {


@Query(value = "select * from itempedidoinfo", nativeQuery = true)
    List<Item_Pedido> buscarTodosPedidos();
}
