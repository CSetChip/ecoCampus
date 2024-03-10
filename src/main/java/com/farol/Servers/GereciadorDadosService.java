package com.farol.Servers;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GereciadorDadosService {

    private Scanner leitor = new Scanner(System.in);

    public String solicitarEntrada(String prompt) {
        System.out.println(prompt);
        return leitor.nextLine();
    }

    public int solicitarInteiro(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um valor inteiro válido.");
            }
        }
    }

    public void printarEntrada(String prompt){
        System.out.println(prompt);
    }

    public long solicitarId(){
        return (long) solicitarInteiro("Insita o id (Valor Inteiro): ");
    }

}
