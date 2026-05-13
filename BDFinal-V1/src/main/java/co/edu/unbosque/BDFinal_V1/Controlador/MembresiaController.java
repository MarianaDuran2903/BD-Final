package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Servicio.MembresiaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    private final MembresiaService membresiaService;

    public MembresiaController(MembresiaService membresiaService) {
        this.membresiaService = membresiaService;
    }

    @GetMapping
    public ResponseEntity<List<MembresiaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(membresiaService.listarTodas());
    }

    @GetMapping("/{cedula}/{idPlan}/{fechaInicio}")
    public ResponseEntity<MembresiaResponseDTO> buscarPorId(
            @PathVariable String cedula,
            @PathVariable Integer idPlan,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio) {
        return membresiaService.buscarPorId(new MembresiaId(cedula, idPlan, fechaInicio))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<MembresiaResponseDTO>> buscarPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(membresiaService.buscarPorMiembro(cedula));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<MembresiaResponseDTO>> buscarPorEstado(@PathVariable EstadoMembresia estado) {
        return ResponseEntity.ok(membresiaService.buscarPorEstado(estado));
    }

    @GetMapping("/activas/{cedula}")
    public ResponseEntity<List<MembresiaResponseDTO>> buscarActivasPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(membresiaService.buscarActivasPorMiembro(cedula));
    }

    @GetMapping("/vigente/{cedula}")
    public ResponseEntity<MembresiaResponseDTO> buscarMembresiaVigente(@PathVariable String cedula) {
        return membresiaService.buscarMembresiaVigente(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MembresiaResponseDTO> guardar(@Valid @RequestBody MembresiaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(membresiaService.guardar(dto));
    }

    @PutMapping("/{cedula}/{idPlan}/{fechaInicio}")
    public ResponseEntity<MembresiaResponseDTO> actualizar(
            @PathVariable String cedula,
            @PathVariable Integer idPlan,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @Valid @RequestBody MembresiaRequestDTO dto) {
        return ResponseEntity.ok(membresiaService.actualizar(new MembresiaId(cedula, idPlan, fechaInicio), dto));
    }

    @DeleteMapping("/{cedula}/{idPlan}/{fechaInicio}")
    public ResponseEntity<Void> eliminar(
            @PathVariable String cedula,
            @PathVariable Integer idPlan,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio) {
        membresiaService.eliminar(new MembresiaId(cedula, idPlan, fechaInicio));
        return ResponseEntity.noContent().build();
    }
}
