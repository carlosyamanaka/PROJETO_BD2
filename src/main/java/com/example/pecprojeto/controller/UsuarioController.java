package com.example.pecprojeto.controller;

import com.example.pecprojeto.entity.Item_Pedido;
import com.example.pecprojeto.entity.Pedido;
import com.example.pecprojeto.entity.Usuario;
import com.example.pecprojeto.repository.Item_PedidoRepository;
import com.example.pecprojeto.repository.PedidoRepository;
import com.example.pecprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    /*Aqui foi desenvolvido o controller referente ao Usuário*/

    /*O controller é responsável por receber as requisições HTTP
    e as direcionar para os métodos adequados no repositório,
    permitindo a implementação da lógica de negócio e retornando
    as respostas correspondentes.*/


    /*Declara-se o repositório referente ao usuário*/
    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;
    private final Item_PedidoRepository item_pedidoRepository;

    public UsuarioController (@Autowired UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository, Item_PedidoRepository itemPedidoRepository){
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
        item_pedidoRepository = itemPedidoRepository;
    }

    /*Foi desenvolvida a função responsável pela busca*/
    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    /*Foi desenvolvida a função responsável por salvar*/
    @PostMapping()
    public ResponseEntity post(@RequestBody Usuario usuario){
        try{
            return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*Foi desenvolvida a função responsável por deletar*/
    @DeleteMapping("{id_usuario}")
    public ResponseEntity delete(@PathVariable Integer id_usuario) {
        try {
            Integer id_pedido = pedidoRepository.findUsuarioId(id_usuario);

            List<Item_Pedido> item_pedidos = item_pedidoRepository.findByPedidoId(id_pedido);

            for (Item_Pedido item_pedido : item_pedidos) {
                // Excluir individualmente cada pedido e seus itens
                item_pedidoRepository.delete(item_pedido);

            }
            List<Pedido> pedidos = pedidoRepository.findByUsuarioId(id_usuario);

            for (Pedido pedido : pedidos) {
                // Excluir individualmente cada pedido e seus itens
                pedidoRepository.delete(pedido);
            }

            usuarioRepository.deleteById(id_usuario);

            return new ResponseEntity<>("Usuário e pedidos removidos com sucesso!", HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

