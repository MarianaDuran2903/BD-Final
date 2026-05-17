package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.EjercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
    public ResponseEntity<List<EjercicioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(ejercicioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjercicioResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ejercicioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/asignacion/{idAsignacion}")
    public ResponseEntity<List<EjercicioResponseDTO>> buscarPorAsignacion(@PathVariable Integer idAsignacion) {
        return ResponseEntity.ok(ejercicioService.buscarPorAsignacion(idAsignacion));
    }

    @PostMapping
    public ResponseEntity<EjercicioResponseDTO> guardar(@Valid @RequestBody EjercicioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ejercicioService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EjercicioResponseDTO> actualizar(@PathVariable Integer id,
                                                           @Valid @RequestBody EjercicioRequestDTO dto) {
        return ResponseEntity.ok(ejercicioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ejercicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
