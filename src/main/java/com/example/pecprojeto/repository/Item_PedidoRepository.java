package com.example.pecprojeto.repository;

import com.example.pecprojeto.entity.Item_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_PedidoRepository extends JpaRepository<Item_Pedido, Integer> {

}
