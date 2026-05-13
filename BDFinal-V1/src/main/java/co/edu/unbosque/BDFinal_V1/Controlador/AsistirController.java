package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.AsistirService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistirController {

    private final AsistirService asistirService;

    public AsistirController(AsistirService asistirService) {
        this.asistirService = asistirService;
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<AsistirResponseDTO>> consultarPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(asistirService.consultarPorMiembro(cedula));
    }

    @GetMapping("/clase/{idClase}")
    public ResponseEntity<List<AsistirResponseDTO>> consultarPorClase(@PathVariable Integer idClase) {
        return ResponseEntity.ok(asistirService.consultarPorClase(idClase));
    }

    @GetMapping("/clase/{idClase}/count")
    public ResponseEntity<Long> contarAsistenciasPorClase(@PathVariable Integer idClase) {
        return ResponseEntity.ok(asistirService.contarAsistenciasPorClase(idClase));
    }

    @GetMapping("/inscrito")
    public ResponseEntity<Boolean> yaEstaInscrito(@RequestParam String cedula,
                                                   @RequestParam Integer idClase) {
        return ResponseEntity.ok(asistirService.yaEstaInscrito(cedula, idClase));
    }

    @PostMapping
    public ResponseEntity<AsistirResponseDTO> registrarAsistencia(@Valid @RequestBody AsistirRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistirService.registrarAsistencia(dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> cancelarAsistencia(@Valid @RequestBody AsistirRequestDTO dto) {
        asistirService.cancelarAsistencia(dto);
        return ResponseEntity.noContent().build();
    }
}
