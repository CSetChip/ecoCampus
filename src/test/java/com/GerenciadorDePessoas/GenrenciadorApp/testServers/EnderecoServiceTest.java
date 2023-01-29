package com.GerenciadorDePessoas.GenrenciadorApp.testServers;

import com.GerenciadorDePessoas.GenrenciadorApp.Controller.EnderecosController;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Endereco;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnderecoServiceTest {

    @Autowired
    private EnderecosController enderecosController;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void buscarenderecos() {
        ResponseEntity<List<Endereco>> response = enderecosController.getListaPessoas();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
