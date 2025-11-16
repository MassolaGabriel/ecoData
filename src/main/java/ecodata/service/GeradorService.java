package ecodata.service;

import ecodata.model.Gerador;
import ecodata.repository.GeradorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeradorService {
    @Autowired
    private GeradorRepository geradorRepository;

    public List<Gerador> listarTodosGeradores() {
        return geradorRepository.findAll();
    }

    public Optional<Gerador> buscarGeradorPorId(Long id) {
        return geradorRepository.findById(id);
    }

    public Gerador salvarGerador(Gerador gerador){
        return geradorRepository.save(gerador);
    }

    public Gerador atualizarGerador(Long id, Gerador geradorAtualizado){
        Gerador gerador = geradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerador não encontrado com id: " + id));

        gerador.setNome(geradorAtualizado.getNome());
        gerador.setCnpjOuCpf(geradorAtualizado.getCnpjOuCpf());
        gerador.setEndereco(geradorAtualizado.getEndereco());
        gerador.setResiduos(geradorAtualizado.getResiduos());

        return geradorRepository.save(gerador);
    }

    @Transactional
    public void deletarGerador(Long id){
        geradorRepository.deleteById(id);
    }


}
