package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> listarTodos() {
        return ResponseEntity.ok(planService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanResponseDTO> buscarPorId(@PathVariable Integer id) {
        return planService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/duracion/{duracion}")
    public ResponseEntity<List<PlanResponseDTO>> buscarPorDuracion(@PathVariable DuracionPlan duracion) {
        return ResponseEntity.ok(planService.buscarPorDuracion(duracion));
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> guardar(@Valid @RequestBody PlanRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanResponseDTO> actualizar(@PathVariable Integer id,
                                                      @Valid @RequestBody PlanRequestDTO dto) {
        return ResponseEntity.ok(planService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        planService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
