package com.GerenciadorDePessoas.GenrenciadorApp.Controller;

import com.GerenciadorDePessoas.GenrenciadorApp.Servers.GerenciadorService;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pessoas")
@Controller
public class GerenciadorController {

    @Autowired
    private GerenciadorService gerenciadorService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getListaPessoas() {
        return ResponseEntity.ok().body(gerenciadorService.listarPessoas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
        return ResponseEntity.ok().body(gerenciadorService.buscarPessoaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(gerenciadorService.salvarpessoa(pessoa));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Pessoa> atualizarDados(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.ok().body(gerenciadorService.salvarpessoa(pessoa));
    }

}
