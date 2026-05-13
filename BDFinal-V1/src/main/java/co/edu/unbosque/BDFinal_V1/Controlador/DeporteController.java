package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.DeporteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deportes")
public class DeporteController {

    private final DeporteService deporteService;

    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping
    public ResponseEntity<List<DeporteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(deporteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeporteResponseDTO> buscarPorId(@PathVariable Integer id) {
        return deporteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<DeporteResponseDTO> buscarPorNombre(@PathVariable String nombre) {
        return deporteService.buscarPorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DeporteResponseDTO> guardar(@Valid @RequestBody DeporteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deporteService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeporteResponseDTO> actualizar(@PathVariable Integer id,
                                                         @Valid @RequestBody DeporteRequestDTO dto) {
        return ResponseEntity.ok(deporteService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        deporteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
