package com.farol.view;

import com.farol.Servers.GereciadorDadosService;
import com.farol.models.Bicicleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuBicicleta {

    @Autowired
    private com.farol.controllers.BicicletaController bicicletaController;

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public void menu() throws Exception {
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            int opcao = gereciadorDadosService.solicitarInteiro("********* Sistema De Bicicletas *********" +
                    "\nDigite uma opção\n1 - Listar Bicicletas\n2 - Buscar Bicicleta Por Id" +
                    "\n3 - Cadastrar Bicicleta\n4 - Atualizar Informações De Bicicletas" +
                    "\n5 - Deletar Informações De Bicicleta\nOpção (Digite um inteiro válido): ");

            if (opcao == 1) {
                mostrarBicicletas(bicicletaController.listarBicicletas());
            } else if (opcao == 2) {
                mostrarBicicleta(bicicletaController.buscarBicicletaPorId(gereciadorDadosService.solicitarId()));
            } else if (opcao == 3) {
                bicicletaController.salvarBicicleta(cadastrarBicicleta());
            } else if (opcao == 4) {
                long id = gereciadorDadosService.solicitarInteiro("Insita o id (Valor Inteiro): ");
                bicicletaController.atualizarBicicleta(id, atualizarBicicleta(id));
            } else if (opcao == 5) {
                bicicletaController.deletarBicicleta((long) gereciadorDadosService.solicitarInteiro("Insita o id (Valor Inteiro): "));
            } else {
                gereciadorDadosService.printarEntrada("Opção inválida!");
            }

            continuar = gereciadorDadosService.solicitarEntrada("Processo Concluido\nIr Para o Menu? (s/n)");

        }
    }

    public void mostrarBicicleta(Bicicleta bicicleta){
        gereciadorDadosService.printarEntrada("\nId: " + bicicleta.getId() +
                "\nMarca: " + bicicleta.getMarca() + "\nModelo: " + bicicleta.getModelo() +
                "\nCor: " + bicicleta.getCor() + "\nAno: " + bicicleta.getAno());
    }

    private void mostrarBicicletas(List<Bicicleta> listaDeBicicletas){
        for (Bicicleta bicicleta : listaDeBicicletas) {
            mostrarBicicleta(bicicleta);
        }
    }

    private Bicicleta cadastrarBicicleta(){
        Bicicleta bicicleta = new Bicicleta();

        gereciadorDadosService.printarEntrada("********* Cadastro De Bicicleta *********");

        bicicleta.setMarca(gereciadorDadosService.solicitarEntrada("Marca: "));
        bicicleta.setModelo(gereciadorDadosService.solicitarEntrada("Modelo: "));
        bicicleta.setCor(gereciadorDadosService.solicitarEntrada("Cor: "));
        bicicleta.setAno(gereciadorDadosService.solicitarInteiro("Ano:"));

        return bicicleta;
    }

    private Bicicleta atualizarBicicleta(long id) throws Exception {
        Bicicleta bicicleta = bicicletaController.buscarBicicletaPorId(id);
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s") ) {
            int opcao = gereciadorDadosService.solicitarInteiro("O Que Deseja Atualizar?\n1 - Marca\n" +
                    "2 - Modelo \n3 - Cor\n4 - Ano\nOpção (Insira um valor inteiro):");

            switch (opcao) {
                case 1:
                    bicicleta.setMarca(gereciadorDadosService.solicitarEntrada("Nova Marca: "));
                    break;
                case 2:
                    bicicleta.setModelo(gereciadorDadosService.solicitarEntrada("Novo Modelo: "));
                    break;
                case 3:
                    bicicleta.setCor(gereciadorDadosService.solicitarEntrada("Cor: "));
                    break;
                case 4:
                    bicicleta.setAno(gereciadorDadosService.solicitarInteiro("Ano:"));
                    break;
                default:
                    gereciadorDadosService.printarEntrada("Opção inválida! Digite novamente.");
                    break;
            }

            continuar = gereciadorDadosService.solicitarEntrada("Continuar? (s/n) ");
        }

        bicicletaController.salvarBicicleta(bicicleta);
        return bicicleta;
    }
}
