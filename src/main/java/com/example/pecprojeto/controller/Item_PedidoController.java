package com.example.pecprojeto.controller;

import com.example.pecprojeto.DTO.ItemPedidoPedidoDTO;
import com.example.pecprojeto.entity.Item_Pedido;
import com.example.pecprojeto.entity.Produto;
import com.example.pecprojeto.repository.Item_PedidoRepository;
import com.example.pecprojeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/itempedido")
public class Item_PedidoController {


    /*Aqui foi desenvolvido o controller referente ao Item_Pedido*/

    /*O controller é responsável por receber as requisições HTTP
    e as direcionar para os métodos adequados no repositório,
    permitindo a implementação da lógica de negócio e retornando
    as respostas correspondentes.*/


    /*/Abaixo foram declarados os repositórios utilizados, no caso, Produto e Item_Pedido*/
    private final ProdutoRepository produtoRepository;
    private final Item_PedidoRepository item_pedidoRepository;

    public Item_PedidoController(@Autowired ProdutoRepository produtoRepository, @Autowired Item_PedidoRepository item_pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.item_pedidoRepository = item_pedidoRepository;
    }

    /*Permite a exibição do relatório envolvendo uma operação JOIN*/
    @GetMapping("/itempedidoproduto")
    public ResponseEntity getItemPedidoProduto(){
        List<Item_Pedido> itemPedidos = item_pedidoRepository.buscarItemPedidoProduto().stream().map(itemPedido -> {
            Produto produto = produtoRepository.findById(itemPedido.getId_produto()).get();
            itemPedido.setNome(produto.getNome());
            itemPedido.setPreco(produto.getPreco());
            return itemPedido;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
    }

    /*Permite exibição do relatório utilizando uma visão previamente
    criada em uma consulta*/
    @GetMapping("/itempedidopedido")
    public ResponseEntity getItemPedidoPedido(){
        List<ItemPedidoPedidoDTO> itemPedidoPedido = item_pedidoRepository.buscarItemPedidoPedido();
        return new ResponseEntity<>(itemPedidoPedido, HttpStatus.OK);
    }

}
