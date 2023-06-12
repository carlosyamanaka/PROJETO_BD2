package com.example.pecprojeto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoPedidoDTO {

    private Integer id_pedido;
    private Integer id_itempedido;
    private Integer quantidade;
    private Integer id_produto;
    private LocalDate data;
    private Integer id_usuario;
}
