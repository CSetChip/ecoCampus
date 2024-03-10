package com.farol.controllers;

import com.farol.Servers.BicicletaService;
import com.farol.models.Bicicleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BicicletaController {

    @Autowired
    private BicicletaService bicicletaService;

    public List<Bicicleta> listarBicicletas() {
        return bicicletaService.listarBicicletas();
    }

    public void salvarBicicleta( Bicicleta bicicleta) {
        bicicletaService.salvarBicicleta(bicicleta);
    }

    public Bicicleta buscarBicicletaPorId( Long id) throws Exception {
        return bicicletaService.buscarBicicletaPorId(id);
    }


    public Bicicleta atualizarBicicleta( Long id, Bicicleta bicicleta) throws Exception {
        return bicicletaService.atualizarBicicleta(id, bicicleta);
    }

    public void deletarBicicleta( Long id) throws Exception {
        bicicletaService.deletarBicicleta(id);
    }
}
