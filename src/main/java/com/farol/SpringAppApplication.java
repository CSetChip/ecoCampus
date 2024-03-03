package com.farol;

import com.farol.Servers.BicicletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringAppApplication implements CommandLineRunner {

    @Autowired
    BicicletaService bicicletaService;
    Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {

            System.out.println("********* Bem Vindo(a) ao Sistema *********" +
                    "\nDigite uma opção:" +
                    "\n1 - Listar Veiculos" +
                    "\n2 - Cadastrar Bicicleta");

            int opcao = Integer.parseInt(leitor.nextLine());

            if (opcao == 1) {
                bicicletaService.listarBicicletas();
            } else if (opcao == 2) {
                bicicletaService.salvarBicicleta(leitor);
            } else {
                System.out.println("Opcao invalida fim do programa");
            }

            System.out.println("Continuar? [s/n]");
            continuar = leitor.nextLine();
        }
    }
}
