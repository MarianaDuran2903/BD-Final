package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import co.edu.unbosque.BDFinal_V1.Servicio.RestriccionMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restricciones-medicas")
public class RestriccionMedicaController {

    private final RestriccionMedicaService restriccionMedicaService;

    public RestriccionMedicaController(RestriccionMedicaService restriccionMedicaService) {
        this.restriccionMedicaService = restriccionMedicaService;
    }

    @GetMapping
    public ResponseEntity<List<RestriccionMedicaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(restriccionMedicaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestriccionMedicaResponseDTO> buscarPorId(@PathVariable Integer id) {
        return restriccionMedicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<RestriccionMedicaResponseDTO>> buscarPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(restriccionMedicaService.buscarPorMiembro(cedula));
    }

    @GetMapping("/gravedad/{nivel}")
    public ResponseEntity<List<RestriccionMedicaResponseDTO>> buscarPorNivelGravedad(@PathVariable NivelGravedad nivel) {
        return ResponseEntity.ok(restriccionMedicaService.buscarPorNivelGravedad(nivel));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<RestriccionMedicaResponseDTO>> buscarPorTipo(@PathVariable TipoRestriccion tipo) {
        return ResponseEntity.ok(restriccionMedicaService.buscarPorTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<RestriccionMedicaResponseDTO> guardar(@Valid @RequestBody RestriccionMedicaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restriccionMedicaService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestriccionMedicaResponseDTO> actualizar(@PathVariable Integer id,
                                                                   @Valid @RequestBody RestriccionMedicaRequestDTO dto) {
        return ResponseEntity.ok(restriccionMedicaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        restriccionMedicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
