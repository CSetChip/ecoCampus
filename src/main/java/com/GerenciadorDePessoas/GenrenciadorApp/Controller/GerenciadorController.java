package com.GerenciadorDePessoas.GenrenciadorApp.Controller;

import com.GerenciadorDePessoas.GenrenciadorApp.Servers.GerenciadorService;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pessoas")
@Controller
public class GerenciadorController {

    @Autowired
    private GerenciadorService gerenciadorService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getListaPessoas() {
        return ResponseEntity.ok().body(this.gerenciadorService.listarPessoas());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
        return ResponseEntity.ok().body(gerenciadorService.buscarPessoaPorId(id));
    }

}
