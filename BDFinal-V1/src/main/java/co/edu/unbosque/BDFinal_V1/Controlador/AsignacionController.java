package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.AsignacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public ResponseEntity<List<AsignacionResponseDTO>> listarTodas() {
        return ResponseEntity.ok(asignacionService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionResponseDTO> buscarPorId(@PathVariable Integer id) {
        return asignacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/entrenador/{cedula}")
    public ResponseEntity<List<AsignacionResponseDTO>> listarPorEntrenador(@PathVariable String cedula) {
        return ResponseEntity.ok(asignacionService.listarPorEntrenador(cedula));
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<AsignacionResponseDTO>> listarPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(asignacionService.listarPorMiembro(cedula));
    }

    @PostMapping
    public ResponseEntity<AsignacionResponseDTO> crear(@Valid @RequestBody AsignacionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asignacionService.crear(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asignacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
