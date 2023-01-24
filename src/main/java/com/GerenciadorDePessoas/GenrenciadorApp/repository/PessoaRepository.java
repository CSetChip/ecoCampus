package com.GerenciadorDePessoas.GenrenciadorApp.repository;

import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
