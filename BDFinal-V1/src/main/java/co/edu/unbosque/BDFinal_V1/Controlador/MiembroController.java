package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.MiembroRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MiembroResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import co.edu.unbosque.BDFinal_V1.Servicio.MiembroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    @GetMapping
    public ResponseEntity<List<MiembroResponseDTO>> listarTodos() {
        return ResponseEntity.ok(miembroService.listarTodos());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<MiembroResponseDTO> buscarPorCedula(@PathVariable String cedula) {
        return miembroService.buscarPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<MiembroResponseDTO>> buscarPorNivelExperiencia(@PathVariable NivelExperiencia nivel) {
        return ResponseEntity.ok(miembroService.buscarPorNivelExperiencia(nivel));
    }

    @GetMapping("/altura")
    public ResponseEntity<List<MiembroResponseDTO>> buscarPorRangoAltura(@RequestParam Short min,
                                                                          @RequestParam Short max) {
        return ResponseEntity.ok(miembroService.buscarPorRangoAltura(min, max));
    }

    @GetMapping("/peso")
    public ResponseEntity<List<MiembroResponseDTO>> buscarPorRangoPeso(@RequestParam BigDecimal min,
                                                                        @RequestParam BigDecimal max) {
        return ResponseEntity.ok(miembroService.buscarPorRangoPeso(min, max));
    }

    @GetMapping("/{cedula}/existe")
    public ResponseEntity<Boolean> existeMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(miembroService.existeMiembro(cedula));
    }

    @PostMapping
    public ResponseEntity<MiembroResponseDTO> guardar(@Valid @RequestBody MiembroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(miembroService.guardar(dto));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<MiembroResponseDTO> actualizar(@PathVariable String cedula,
                                                         @Valid @RequestBody MiembroRequestDTO dto) {
        return ResponseEntity.ok(miembroService.actualizar(cedula, dto));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        miembroService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}
