package com.GerenciadorDePessoas.GenrenciadorApp.testServers;

import com.GerenciadorDePessoas.GenrenciadorApp.Controller.GerenciadorController;
import com.GerenciadorDePessoas.GenrenciadorApp.Exceptions.IdNotFoundException;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GerenciadorServiceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private GerenciadorController gerenciadorController;

    @Autowired
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa;

    @BeforeAll
    public void inicializar(){
        pessoaRepository.save(new Pessoa(1,"beatriz", LocalDate.parse("2018-01-01"),null));
    }

    @Test
    public void buscaTodasAsPessoas() {
        ResponseEntity<List<Pessoa>> response = gerenciadorController.getListaPessoas();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void bucarPessoaComIdValido(){
        ResponseEntity<Pessoa> response = gerenciadorController.buscarPessoa(1L);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getId(), 1);
    }

    @Test
    public void buscarPessoaComIdInvalido(){
        assertThrows(IdNotFoundException.class, () -> gerenciadorController.buscarPessoa(2L));
    }

    @Test
    public void  cadastrarPessoaComArgumentosvalidos(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Emanuel");
        pessoa.setDataDeNascimento(LocalDate.parse("2018-04-12"));

        ResponseEntity<Pessoa> response = gerenciadorController.cadastrarPessoa(pessoa);

        assertEquals(response.getBody().getNome(), "Emanuel");
        assertEquals(response.getBody().getId(), 2);
        assertEquals(response.getBody().getDataDeNascimento(), LocalDate.parse("2018-04-12"));
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void  atualizarDadosDeUmaPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setNome("Larissa");
        pessoa.setDataDeNascimento(LocalDate.parse("2001-12-04"));

        ResponseEntity<Pessoa> response = gerenciadorController.atualizarDados(pessoa);

        assertEquals(response.getBody().getNome(), "Larissa");
        assertEquals(response.getBody().getId(), 1);
        assertEquals(response.getBody().getDataDeNascimento(), LocalDate.parse("2001-12-04"));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
