package com.example.pecprojeto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;

    @Column(name = "nome")
    private String nome;

    @Column(length = 20, precision = 20, scale = 2, nullable = false, name = "preco")
    private BigDecimal preco;

}
