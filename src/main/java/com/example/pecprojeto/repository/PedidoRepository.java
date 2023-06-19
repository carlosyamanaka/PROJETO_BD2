package com.example.pecprojeto.repository;

import com.example.pecprojeto.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    /*Repositórios declarados para suas respectivas identificações*/

    @Query("SELECT p FROM Pedido p WHERE p.id_usuario = :idUsuario")
    List<Pedido> findByUsuarioId(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT p.id_pedido FROM Pedido p WHERE p.id_usuario = :idUsuario")
    Integer findUsuarioId(@Param("idUsuario") Integer idUsuario);
}
