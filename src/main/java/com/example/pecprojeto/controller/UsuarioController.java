package com.example.pecprojeto.controller;

import com.example.pecprojeto.entity.Usuario;
import com.example.pecprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController (@Autowired UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody Usuario usuario){
        try{
            return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity put (@RequestBody Usuario usuario){
        Optional<Usuario> userToEdit = usuarioRepository.findById(usuario.getId_usuario());
        if(userToEdit.isPresent()){
            usuarioRepository.save(usuario);
            return  new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id_usuario}")
    public ResponseEntity delete(@PathVariable Integer id_usuario){
        try{
            usuarioRepository.deleteById(id_usuario);
            return new ResponseEntity<>("Usuário removido com sucesso!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

