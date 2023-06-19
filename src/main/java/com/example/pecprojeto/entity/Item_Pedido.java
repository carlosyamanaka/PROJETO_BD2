package com.example.pecprojeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Item_Pedido")
public class Item_Pedido {

    /*Mapeada a entidade referente ao Item_pedido*/

    /*Entidade se trata da representação em código de objetos reais,
    nesse caso foi mapeada a entidade referente ao Item Pedido*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itempedido")
    private Integer id_itempedido;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "id_pedido", nullable = false)
    private Integer id_pedido;

    @Column(name = "id_produto", nullable = false)
    private Integer id_produto;

    @Transient
    private String nome;

    @Transient
    private BigDecimal preco;

}
