package com.farol.view;

import com.farol.Servers.GereciadorDadosService;
import com.farol.Servers.PontoAcessoService;
import com.farol.controller.PontoAcessoController;
import com.farol.models.Bicicleta;
import com.farol.models.Estudante;
import com.farol.models.PontoAcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuPontoAcesso {

    @Autowired
    private PontoAcessoController pontoAcessoController;

    @Autowired
    private com.farol.controllers.BicicletaController bicicletaController;

    @Autowired
    private MenuBicicleta menuBicicleta;

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public void menu() throws Exception {
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            int opcao = gereciadorDadosService.solicitarInteiro("********* Gerenciar Ponto De Acesso *********" +
                    "\nDigite uma opção\n1 - Listar Bicicletas\n2 - Cadastrar Bicicleta" +
                    "\nOpção (Digite um inteiro válido): ");

            if (opcao == 1) {
                mostrarPontosAcesso(pontoAcessoController.listarPontosAcesso());
            } else if (opcao == 2) {
                pontoAcessoController.salvarPontoDeAcesso(cadastrarPontoAcesso());
            } else {
                gereciadorDadosService.printarEntrada("Opção inválida!");
            }

            continuar = gereciadorDadosService.solicitarEntrada("Processo Concluido\nIr Para o Menu? (s/n)");

        }
    }

    private void printarPontosDeAcesso(PontoAcesso pontoAcesso) throws Exception {
        gereciadorDadosService.printarEntrada("\nId: " + pontoAcesso.getId() +
                "\nInstituição: " + pontoAcesso.getInstituicao() + "\nEndereço: " + pontoAcesso.getEndereco());

        if(pontoAcesso.getBicicletas() != null) {
            List<Bicicleta> listabicicletas = bicicletaController.listarBicicletas();
            for (Bicicleta bicicleta : listabicicletas) {
                if (bicicleta.getPontoAcesso().getId() == pontoAcesso.getId()) {
                    menuBicicleta.mostrarBicicleta(bicicleta);
                }
            }
        }
    }

    private void mostrarPontosAcesso(List<PontoAcesso> listaDePontosAcesso) throws Exception {
        for (PontoAcesso pontosAcesso : listaDePontosAcesso) {
            printarPontosDeAcesso(pontosAcesso);
        }
    }

    private PontoAcesso cadastrarPontoAcesso() {
        PontoAcesso pontoAcesso = new PontoAcesso();

        gereciadorDadosService.printarEntrada("********* Cadastro Ponto De Acesso *********");

        pontoAcesso.setInstituicao(gereciadorDadosService.solicitarEntrada("Instituição: "));
        pontoAcesso.setEndereco(gereciadorDadosService.solicitarEntrada("Endereço: "));

        return pontoAcesso;
    }
}
