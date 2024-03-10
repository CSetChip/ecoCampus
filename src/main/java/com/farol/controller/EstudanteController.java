package com.farol.controller;

import com.farol.Servers.EstudanteService;
import com.farol.models.Bicicleta;
import com.farol.models.Estudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    public List<Estudante> listarEstudante() {
        return estudanteService.listarEstudantes();
    }

    public void salvarEstudante(Estudante estudante) {
        estudanteService.salvarEstudante(estudante);
    }

    public Estudante buscarEstudantePorId(Long id) throws Exception {
        return estudanteService.buscarEstudantePorId(id);
    }


    public Estudante atualizarEstudante(Long id, Estudante estudante) throws Exception {
        return estudanteService.atualizarEstudante(id, estudante);
    }

    public void deletarEstudante(Long id) throws Exception {estudanteService.deletarEstudante(id);}
}
