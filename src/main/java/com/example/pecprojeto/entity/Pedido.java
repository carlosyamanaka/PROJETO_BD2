package com.example.pecprojeto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    /*Mapeada a entidade referente ao Pedido*/

    /*Entidade se trata da representação em código de objetos reais,
    nesse caso foi mapeada a entidade referente ao Pedido*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id_pedido;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "id_usuario")
    private Integer id_usuario;

}
