package com.example.pecprojeto;

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

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 10, precision = 2, nullable = true)
    private Long preco;

}
