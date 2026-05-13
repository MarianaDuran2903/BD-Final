package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import co.edu.unbosque.BDFinal_V1.Servicio.ClaseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public ResponseEntity<List<ClaseResponseDTO>> listarTodas() {
        return ResponseEntity.ok(claseService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseResponseDTO> buscarPorId(@PathVariable Integer id) {
        return claseService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/entrenador/{cedula}")
    public ResponseEntity<List<ClaseResponseDTO>> buscarPorEntrenador(@PathVariable String cedula) {
        return ResponseEntity.ok(claseService.buscarPorEntrenador(cedula));
    }

    @GetMapping("/deporte/{idDeporte}")
    public ResponseEntity<List<ClaseResponseDTO>> buscarPorDeporte(@PathVariable Integer idDeporte) {
        return ResponseEntity.ok(claseService.buscarPorDeporte(idDeporte));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ClaseResponseDTO>> buscarPorEstado(@PathVariable EstadoClase estado) {
        return ResponseEntity.ok(claseService.buscarPorEstado(estado));
    }

    @GetMapping("/sala/{idSala}")
    public ResponseEntity<List<ClaseResponseDTO>> buscarPorSala(@PathVariable Integer idSala) {
        return ResponseEntity.ok(claseService.buscarPorSala(idSala));
    }

    @PostMapping
    public ResponseEntity<ClaseResponseDTO> guardar(@Valid @RequestBody ClaseRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(claseService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseResponseDTO> actualizar(@PathVariable Integer id,
                                                       @Valid @RequestBody ClaseRequestDTO dto) {
        return ResponseEntity.ok(claseService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/entrenador/{cedula}")
    public ResponseEntity<ClaseResponseDTO> asignarEntrenador(@PathVariable Integer id,
                                                              @PathVariable String cedula) {
        return ResponseEntity.ok(claseService.asignarEntrenador(id, cedula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        claseService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
