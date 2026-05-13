package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Servicio.EntrenadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(entrenadorService.listarTodos());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<EntrenadorResponseDTO> buscarPorCedula(@PathVariable String cedula) {
        return entrenadorService.buscarPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<EntrenadorResponseDTO>> buscarPorTipoEntrenamiento(@PathVariable TipoEntrenamiento tipo) {
        return ResponseEntity.ok(entrenadorService.buscarPorTipoEntrenamiento(tipo));
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<EntrenadorResponseDTO>> buscarPorNivelExigencia(@PathVariable NivelExigencia nivel) {
        return ResponseEntity.ok(entrenadorService.buscarPorNivelExigencia(nivel));
    }

    @GetMapping("/deporte/{idDeporte}")
    public ResponseEntity<List<EntrenadorResponseDTO>> buscarPorDeporte(@PathVariable Integer idDeporte) {
        return ResponseEntity.ok(entrenadorService.buscarPorDeporte(idDeporte));
    }

    @GetMapping("/{cedula}/existe")
    public ResponseEntity<Boolean> existeEntrenador(@PathVariable String cedula) {
        return ResponseEntity.ok(entrenadorService.existeEntrenador(cedula));
    }

    @PostMapping
    public ResponseEntity<EntrenadorResponseDTO> guardar(@Valid @RequestBody EntrenadorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenadorService.guardar(dto));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<EntrenadorResponseDTO> actualizar(@PathVariable String cedula,
                                                            @Valid @RequestBody EntrenadorRequestDTO dto) {
        return ResponseEntity.ok(entrenadorService.actualizar(cedula, dto));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        entrenadorService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}
