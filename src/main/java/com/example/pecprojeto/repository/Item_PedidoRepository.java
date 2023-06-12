package com.example.pecprojeto.repository;

import com.example.pecprojeto.DTO.ItemPedidoPedidoDTO;
import com.example.pecprojeto.entity.Item_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Item_PedidoRepository extends JpaRepository<Item_Pedido, Integer> {

    @Query(value = "select * from itempedidoinfo", nativeQuery = true)
    List<Item_Pedido> buscarItemPedidoProduto();

    @Query(value = "SELECT new com.example.pecprojeto.DTO.ItemPedidoPedidoDTO(ip.id_pedido, ip.id_itempedido, ip.quantidade, ip.id_produto, p.data, p.id_usuario) FROM Item_Pedido ip inner join Pedido p ON p.id_pedido = ip.id_pedido")
    List<ItemPedidoPedidoDTO> buscarItemPedidoPedido();
}
