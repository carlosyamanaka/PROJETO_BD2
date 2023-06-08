package com.example.pecprojeto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Item_Pedido")
public class Item_Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_itempedido;

    @Column(nullable = false)
    private Integer id_pedido;

    @Column(nullable = false)
    private Integer id_produto;

    @Column(nullable = false)
    private Integer quantidade;

}
