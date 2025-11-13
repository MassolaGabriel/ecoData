package ecodata.service;

import ecodata.model.Residuo;
import ecodata.model.enums.StatusResiduo;
import ecodata.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    public List<Residuo> listarTodosResiduos() {
        return residuoRepository.findAll();
    }

    public Optional<Residuo> buscarResiduoPorId(Long id) {
        return residuoRepository.findById(id);
    }

    public List<Residuo> buscarResiduosPorStatus(String status) {
        try {
            StatusResiduo statusEnum = StatusResiduo.valueOf(status.toUpperCase());
            return residuoRepository.findByStatusResiduo(statusEnum);
        } catch (IllegalArgumentException e) {
            System.err.println("Status inválido: " + status);
            return List.of();
        }
    }
}
