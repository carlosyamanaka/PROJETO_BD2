package com.example.pecprojeto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    //FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario);
    //Teste
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column(name = "sales_date", nullable = false)
    private LocalDate data;

    @Column()
    private Integer id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<Item_Pedido> items;

}
