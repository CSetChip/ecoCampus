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

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public List<Bicicleta> listarBicicletas() {
        return bicicletaRepository.findAll();
    }


    public Bicicleta salvarBicicleta(Bicicleta bicicleta){
        return bicicletaRepository.save(bicicleta);

    }

    public Bicicleta buscarBicicletaPorId(Long id) throws Exception {
        return bicicletaRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado: " + id));
    }

    public Bicicleta atualizarBicicleta(Long id, Bicicleta novaBicicleta) throws Exception {
        Bicicleta bicicleta = buscarBicicletaPorId(id);

        bicicleta.setMarca(novaBicicleta.getMarca());
        bicicleta.setModelo(novaBicicleta.getModelo());
        bicicleta.setCor(novaBicicleta.getCor());
        bicicleta.setAno(novaBicicleta.getAno());

        bicicletaRepository.save(bicicleta);
        return bicicleta;
    }

    public void deletarBicicleta(Long id) throws Exception {
        bicicletaRepository.deleteById(buscarBicicletaPorId(id).getId());
    }

}