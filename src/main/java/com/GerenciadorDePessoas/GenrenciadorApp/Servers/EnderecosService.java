package com.GerenciadorDePessoas.GenrenciadorApp.Servers;

import com.GerenciadorDePessoas.GenrenciadorApp.models.Endereco;
import com.GerenciadorDePessoas.GenrenciadorApp.models.Pessoa;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.EnderecoRepository;
import com.GerenciadorDePessoas.GenrenciadorApp.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecosService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Pessoa salvarEndereco(Endereco endereco, Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoa.getEnderecos().add(endereco);
        enderecoRepository.save(endereco);
        return pessoa;
    }
}
