package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(salaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Integer id) {
        return salaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/capacidad")
    public ResponseEntity<List<SalaResponseDTO>> buscarPorCapacidadMinima(@RequestParam Short min) {
        return ResponseEntity.ok(salaService.buscarPorCapacidadMinima(min));
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> guardar(@Valid @RequestBody SalaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> actualizar(@PathVariable Integer id,
                                                      @Valid @RequestBody SalaRequestDTO dto) {
        return ResponseEntity.ok(salaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        salaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
