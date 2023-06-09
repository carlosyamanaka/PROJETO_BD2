package com.example.pecprojeto.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column(name = "nome",length = 50, nullable = false)
    private String nome;

    @Column(name = "preco",length = 10, precision = 2)
    private Long preco;

}
