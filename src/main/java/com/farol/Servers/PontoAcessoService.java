package com.farol.Servers;
import com.farol.models.Bicicleta;
import com.farol.models.PontoAcesso;
import com.farol.repository.PontoACessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoAcessoService {

    @Autowired
    private PontoACessoRepository pontoACessoRepository;

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public List<PontoAcesso> listarPontosDeAcesso() {
        return pontoACessoRepository.findAll();
    }


    public PontoAcesso salvarPontoDeAcesso(PontoAcesso pontoAcesso){
        return pontoACessoRepository.save(pontoAcesso);

    }

    public PontoAcesso buscarPontoDeAcessoPorId(Long id) throws Exception {
        return pontoACessoRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado: " + id));
    }

    public PontoAcesso atualizarPontoAcesso(Long id, PontoAcesso novoPonto) throws Exception {
        PontoAcesso pontoAcesso = buscarPontoDeAcessoPorId(id);

        pontoAcesso.setInstituicao(novoPonto.getInstituicao());
        pontoAcesso.setEndereco(novoPonto.getEndereco());

        pontoACessoRepository.save(pontoAcesso);
        return pontoAcesso;
    }

    public void deletarPontoDeAcesso(Long id) throws Exception {
        pontoACessoRepository.deleteById(buscarPontoDeAcessoPorId(id).getId());
    }

}