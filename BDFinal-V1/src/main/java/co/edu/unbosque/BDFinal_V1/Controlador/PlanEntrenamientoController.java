package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanEntrenamientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planes-entrenamiento")
public class PlanEntrenamientoController {

    private final PlanEntrenamientoService planEntrenamientoService;

    public PlanEntrenamientoController(PlanEntrenamientoService planEntrenamientoService) {
        this.planEntrenamientoService = planEntrenamientoService;
    }

    @GetMapping("/asignacion/{id}")
    public ResponseEntity<PlanEntrenamientoResponseDTO> buscarPorAsignacion(@PathVariable Integer id) {
        return planEntrenamientoService.buscarPorAsignacion(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<PlanEntrenamientoResponseDTO>> buscarPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(planEntrenamientoService.buscarPorMiembro(cedula));
    }

    @GetMapping("/entrenador/{cedula}")
    public ResponseEntity<List<PlanEntrenamientoResponseDTO>> buscarPorEntrenador(@PathVariable String cedula) {
        return ResponseEntity.ok(planEntrenamientoService.buscarPorEntrenador(cedula));
    }

    @PostMapping
    public ResponseEntity<PlanEntrenamientoResponseDTO> crear(
            @Valid @RequestBody PlanEntrenamientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planEntrenamientoService.crear(dto));
    }

    @PutMapping("/{idAsignacion}")
    public ResponseEntity<PlanEntrenamientoResponseDTO> actualizar(
            @PathVariable Integer idAsignacion,
            @Valid @RequestBody PlanEntrenamientoRequestDTO dto) {
        return ResponseEntity.ok(planEntrenamientoService.actualizar(idAsignacion, dto));
    }

    @DeleteMapping("/{idAsignacion}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idAsignacion) {
        planEntrenamientoService.eliminar(idAsignacion);
        return ResponseEntity.noContent().build();
    }
}
