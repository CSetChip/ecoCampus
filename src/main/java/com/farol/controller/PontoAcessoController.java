package com.farol.controller;

import com.farol.Servers.PontoAcessoService;
import com.farol.models.Bicicleta;
import com.farol.models.PontoAcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PontoAcessoController {

    @Autowired
    private PontoAcessoService pontoAcessoService;

    public List<PontoAcesso> listarPontosAcesso() {
        return pontoAcessoService.listarPontosDeAcesso();
    }

    public void salvarPontoDeAcesso(PontoAcesso pontoAcesso) {
        pontoAcessoService.salvarPontoDeAcesso(pontoAcesso);
    }

    public PontoAcesso buscarPontoAcessoPorId(Long id) throws Exception {
        return pontoAcessoService.buscarPontoDeAcessoPorId(id);
    }

    public PontoAcesso atualizarPontoAcesso(Long id, PontoAcesso pontoAcesso) throws Exception {
        return pontoAcessoService.atualizarPontoAcesso(id, pontoAcesso);
    }

    public void deletarPontoDeAcesso(Long id) throws Exception {
        pontoAcessoService.deletarPontoDeAcesso(id);
    }
}
