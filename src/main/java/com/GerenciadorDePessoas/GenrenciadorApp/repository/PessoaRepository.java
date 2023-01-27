package com.GerenciadorDePessoas.GenrenciadorApp.repository;

import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
