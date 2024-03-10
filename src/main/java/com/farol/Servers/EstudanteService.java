package com.farol.Servers;

import com.farol.models.Bicicleta;
import com.farol.models.Estudante;
import com.farol.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private GereciadorDadosService gereciadorDadosService;

    public List<Estudante> listarEstudantes() {return  estudanteRepository.findAll();}

    public Estudante salvarEstudante(Estudante estudante){return estudanteRepository.save(estudante);}

    public Estudante buscarEstudantePorId(Long id) throws Exception {
        return estudanteRepository.findById(id).orElseThrow(() -> new Exception("Id não encontrado: " + id));
    }

    public Estudante atualizarEstudante(Long id, Estudante novoEstudante) throws Exception {
        Estudante estudante = buscarEstudantePorId(id);

        estudante.setEmail(novoEstudante.getEmail());
        estudante.setNome(novoEstudante.getNome());
        estudante.setInstituicao(novoEstudante.getInstituicao());
        estudante.setNumero(novoEstudante.getNumero());
        estudante.setMatricula(novoEstudante.getMatricula());

        estudanteRepository.save(estudante);
        return estudante;
    }

    public void deletarEstudante(Long id) throws Exception {
        estudanteRepository.deleteById(buscarEstudantePorId(id).getId());
    }
}
