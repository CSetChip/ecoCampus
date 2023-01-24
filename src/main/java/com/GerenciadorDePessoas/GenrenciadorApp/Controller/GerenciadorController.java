package com.GerenciadorDePessoas.GenrenciadorApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GerenciadorController {

    @RequestMapping("/cadastrarPessoa")
    public String criarPessoa() {
        return "cadastrarPessoa";
    }
}
