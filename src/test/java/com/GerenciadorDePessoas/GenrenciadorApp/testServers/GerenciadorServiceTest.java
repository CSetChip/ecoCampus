package com.GerenciadorDePessoas.GenrenciadorApp.testServers;

import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GerenciadorServiceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void buscaTodasAsPessoas() {
        ResponseEntity<Pessoa[]> response = this.testRestTemplate
                .exchange("/listar", HttpMethod.GET, null, Pessoa[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
