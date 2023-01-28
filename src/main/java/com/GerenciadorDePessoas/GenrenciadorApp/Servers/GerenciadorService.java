package com.GerenciadorDePessoas.GenrenciadorApp.Servers;

import com.GerenciadorDePessoas.GenrenciadorApp.Exceptions.IdNotFoundException;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciadorService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return this.pessoaRepository.findAll();
    }

    public Pessoa buscarPessoaPorId(Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Id não encontrado: " + id));
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

}
