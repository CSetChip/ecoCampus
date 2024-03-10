package com.farol.view;

import com.farol.Servers.GereciadorDadosService;
import com.farol.controller.EstudanteController;
import com.farol.models.Bicicleta;
import com.farol.models.Estudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuEstudante {

    @Autowired
    private EstudanteController estudanteController;

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public void menu() throws Exception {
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            int opcao = gereciadorDadosService.solicitarInteiro("********* Central Do Estudante *********" +
                    "\nDigite uma opção\n1 - Listar Estudantes\n2 - Cadastrar Estudantes" +
                    "\nOpção (Digite um inteiro válido): ");

            if (opcao == 1) {
                mostrarBicicletas(estudanteController.listarEstudante());
            } else if (opcao == 2) {
                estudanteController.salvarEstudante(cadastrarEstudante());
            } else {
                gereciadorDadosService.printarEntrada("Opção inválida!");
            }

            continuar = gereciadorDadosService.solicitarEntrada("Processo Concluido\nIr Para o Menu? (s/n)");

        }
    }

    private void mostrarBicicleta(Estudante estudante){
        gereciadorDadosService.printarEntrada("\nId: " + estudante.getId() +
                "\nNome: " + estudante.getNome() + "\nMatricula: " + estudante.getMatricula() +
                "\nInstituição: " + estudante.getInstituicao() + "\nEmail: " + estudante.getEmail()
                + "\nNúmero: " + estudante.getNumero());
    }

    private void mostrarBicicletas(List<Estudante> listaDeEstudantes){
        for (Estudante estudante : listaDeEstudantes) {
            mostrarBicicleta(estudante);
        }
    }

    private Estudante cadastrarEstudante(){
        Estudante estudante = new Estudante();

        gereciadorDadosService.printarEntrada("********* Cadastro De Bicicleta *********");

        estudante.setNome(gereciadorDadosService.solicitarEntrada("Nome: "));
        estudante.setMatricula(gereciadorDadosService.solicitarInteiro("Matricula: "));
        estudante.setInstituicao(gereciadorDadosService.solicitarEntrada("Instituição: "));
        estudante.setEmail(gereciadorDadosService.solicitarEntrada("Email: "));
        estudante.setNumero(gereciadorDadosService.solicitarInteiro("Número: "));

        return estudante;
    }
}
