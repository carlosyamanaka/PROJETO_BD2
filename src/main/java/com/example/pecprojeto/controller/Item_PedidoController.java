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


    private final ProdutoRepository produtoRepository;
    private final Item_PedidoRepository item_pedidoRepository;

    public Item_PedidoController(@Autowired ProdutoRepository produtoRepository, @Autowired Item_PedidoRepository item_pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.item_pedidoRepository = item_pedidoRepository;
    }

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

    @GetMapping("/itempedidopedido")
    public ResponseEntity getItemPedidoPedido(){
        List<ItemPedidoPedidoDTO> itemPedidoPedido = item_pedidoRepository.buscarItemPedidoPedido();
        return new ResponseEntity<>(itemPedidoPedido, HttpStatus.OK);
    }

}
