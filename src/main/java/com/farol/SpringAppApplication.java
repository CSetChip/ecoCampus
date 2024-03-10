package com.farol;

import com.farol.Servers.GereciadorDadosService;
import com.farol.view.MenuBicicleta;
import com.farol.view.MenuEstudante;
import com.farol.view.MenuPontoAcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppApplication implements CommandLineRunner {
    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    @Autowired
    private MenuBicicleta menuBicicleta;

    @Autowired
    private MenuEstudante menuEstudante;

    @Autowired
    private MenuPontoAcesso pontoAcesso;

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int opcao = 0;

        do{
            opcao = gereciadorDadosService.solicitarInteiro("********* Bem Vindo(a) ao EcoCampus *********"
            + "\nEscolha uma opção:\n1 - Gerenciar Bicicletas.\n2 - Gerenciar Estudantes." +
                    "\n3 - Gerenciar Pontos De Acesso.\n0 - Sair");

            if (opcao == 1){
                menuBicicleta.menu();
            }else if (opcao == 2){
                menuEstudante.menu();
            }else if (opcao == 3){
                pontoAcesso.menu();
            }

        } while (opcao != 0);

        gereciadorDadosService.printarEntrada("********* Volte Sempre ao EcoCampus *********");
    }
}
