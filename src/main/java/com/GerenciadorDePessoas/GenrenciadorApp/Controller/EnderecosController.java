package com.GerenciadorDePessoas.GenrenciadorApp.Controller;

import com.GerenciadorDePessoas.GenrenciadorApp.Servers.EnderecosService;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Endereco;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/endereco")
@Controller
public class EnderecosController {

    @Autowired
    private EnderecosService enderecosService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getListaPessoas() {
        return ResponseEntity.ok().body(enderecosService.listarEnderecos());
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Pessoa> cadastrarEndereco(@Valid @RequestBody Endereco endereco, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecosService.salvarEndereco(endereco, id));
    }
}
