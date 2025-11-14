package ecodata.controller;

import ecodata.model.Residuo;
import ecodata.service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin(origins = "*")
public class ResiduoController {
    @Autowired
    private ResiduoService residuoService;

    @GetMapping
    public List<Residuo> listarTodosResiduos() {
        return residuoService.listarTodosResiduos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residuo> buscarResiduoPorId(@PathVariable Long id) {
        Optional<Residuo> residuo = residuoService.buscarResiduoPorId(id);
        return residuo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Residuo>> buscarResiduosPorStatus(@PathVariable String status) {
        List<Residuo> residuos = residuoService.buscarResiduosPorStatus(status);
        if (residuos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(residuos);
    }

    @PostMapping // (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Residuo> salvarResiduo(@RequestBody Residuo residuo) {
        try {
            Residuo novoResiduo = residuoService.salvarResiduo(residuo);
            return ResponseEntity.ok(novoResiduo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
