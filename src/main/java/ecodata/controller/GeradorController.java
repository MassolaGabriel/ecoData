package ecodata.controller;

import ecodata.model.Gerador;
import ecodata.service.GeradorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/geradores")
@CrossOrigin(origins = "*")
public class GeradorController {
    @Autowired
    public GeradorService geradorService;

    @GetMapping
    public List<Gerador> listarTodosGeradores() {
        return geradorService.listarTodosGeradores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerador> buscarGeradorPorId(@PathVariable Long id) {
        Optional<Gerador> gerador = geradorService.buscarGeradorPorId(id);
        return gerador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Gerador salvarGerador(@RequestBody Gerador gerador) {
        return geradorService.salvarGerador(gerador);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Gerador> atualizarGerador(@PathVariable Long id, @RequestBody Gerador geradorAtualizado) {
        try {
            Gerador gerador = geradorService.atualizarGerador(id, geradorAtualizado);
            return ResponseEntity.ok(gerador);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletarGerador(@PathVariable Long id) {
        geradorService.deletarGerador(id);
        return ResponseEntity.noContent().build();
    }
}
