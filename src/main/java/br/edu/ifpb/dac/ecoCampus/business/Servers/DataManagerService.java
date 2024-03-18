package br.edu.ifpb.dac.ecoCampus.business.Servers;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class DataManagerService {

    private Scanner scanner = new Scanner(System.in);

    public String requestInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int requestInteger(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um valor inteiro válido.");
            }
        }
    }

    public void printInput(String prompt) {
        System.out.println(prompt);
    }

    public long requestID() {
        return (long) requestInteger("Insira o ID (Valor Inteiro): ");
    }
}
