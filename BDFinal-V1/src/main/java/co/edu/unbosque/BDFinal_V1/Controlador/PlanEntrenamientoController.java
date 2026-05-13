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

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<PlanEntrenamientoResponseDTO> buscarPorMiembro(@PathVariable String cedula) {
        return planEntrenamientoService.buscarPorMiembro(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/entrenador/{cedula}")
    public ResponseEntity<List<PlanEntrenamientoResponseDTO>> buscarPorEntrenador(@PathVariable String cedula) {
        return ResponseEntity.ok(planEntrenamientoService.buscarPorEntrenador(cedula));
    }

    @GetMapping("/miembro/{cedula}/tiene-plan")
    public ResponseEntity<Boolean> tienePlanAsignado(@PathVariable String cedula) {
        return ResponseEntity.ok(planEntrenamientoService.tienePlanAsignado(cedula));
    }

    @PostMapping
    public ResponseEntity<PlanEntrenamientoResponseDTO> asignarRutina(
            @Valid @RequestBody PlanEntrenamientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planEntrenamientoService.asignarRutina(dto));
    }

    @PutMapping("/miembro/{cedula}")
    public ResponseEntity<PlanEntrenamientoResponseDTO> actualizarRutina(
            @PathVariable String cedula,
            @Valid @RequestBody PlanEntrenamientoRequestDTO dto) {
        return ResponseEntity.ok(planEntrenamientoService.actualizarRutina(cedula, dto));
    }

    @DeleteMapping("/miembro/{cedula}")
    public ResponseEntity<Void> eliminarRutina(@PathVariable String cedula) {
        planEntrenamientoService.eliminarRutina(cedula);
        return ResponseEntity.noContent().build();
    }
}
