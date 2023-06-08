package com.example.pecprojeto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String senha;

    @Column(length = 80, nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Integer telefone;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos;
}
