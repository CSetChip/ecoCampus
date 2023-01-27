package com.GerenciadorDePessoas.GenrenciadorApp.Controller;

import com.GerenciadorDePessoas.GenrenciadorApp.Servers.GerenciadorService;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class GerenciadorController {

    @Autowired
    private GerenciadorService gerenciadorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> getListaPessoas() {
        return ResponseEntity.ok().body(this.gerenciadorService.listarPessoas());
    }


}
