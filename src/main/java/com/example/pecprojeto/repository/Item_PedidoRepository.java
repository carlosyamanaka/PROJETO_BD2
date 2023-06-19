package com.example.pecprojeto.repository;

import com.example.pecprojeto.DTO.ItemPedidoPedidoDTO;
import com.example.pecprojeto.entity.Item_Pedido;
import com.example.pecprojeto.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Item_PedidoRepository extends JpaRepository<Item_Pedido, Integer> {

    /*Está sendo feita uma consulta nativa para selecionar
    todos os dados da visão "itempedidoinfo" no banco de dados.*/
    @Query(value = "select * from itempedidoinfo", nativeQuery = true)
    List<Item_Pedido> buscarItemPedidoProduto();

    /*Está sendo feita uma consulta personalizada para selecionar
    informações específicas dos itens do pedido, juntamente com dados
    relacionados aos pedidos.*/
    @Query(value = "SELECT new com.example.pecprojeto.DTO.ItemPedidoPedidoDTO(ip.id_pedido, ip.id_itempedido, ip.quantidade, ip.id_produto, p.data, p.id_usuario) FROM Item_Pedido ip inner join Pedido p ON p.id_pedido = ip.id_pedido")
    List<ItemPedidoPedidoDTO> buscarItemPedidoPedido();

    @Query("SELECT i FROM Item_Pedido i WHERE i.id_pedido = :idPedido")
    List<Item_Pedido> findByPedidoId(@Param("idPedido") Integer idPedido);
}
