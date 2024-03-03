package com.farol.Servers;
import com.farol.models.Bicicleta;
import com.farol.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BicicletaService {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    public void listarBicicletas() {
        List<Bicicleta> listaDeBicicletas =  bicicletaRepository.findAll();

        System.out.println("Lista de Bicicletas:");
        for (Bicicleta bicicleta : listaDeBicicletas) {
            System.out.println("Marca: " + bicicleta.getMarca() + "\n" +
                    "Modelo: " + bicicleta.getModelo() + "\n" +
                    "Cor: " + bicicleta.getCor() + "\n" +
                    "Ano: " + bicicleta.getAno() + "\n");
        }
    }

    public void salvarBicicleta(Scanner leitor){
        Bicicleta bicicleta = new Bicicleta();

        System.out.println("********* Cadastro De Bicicleta *********");
        System.out.println("Marca:");
        bicicleta.setMarca(leitor.nextLine());
        System.out.println("Modelo:");
        bicicleta.setModelo(leitor.nextLine());
        System.out.println("Cor:");
        bicicleta.setCor(leitor.nextLine());
        System.out.println("Ano:");
        bicicleta.setAno(Integer.parseInt(leitor.nextLine()));

        bicicletaRepository.save(bicicleta);
    }

}
