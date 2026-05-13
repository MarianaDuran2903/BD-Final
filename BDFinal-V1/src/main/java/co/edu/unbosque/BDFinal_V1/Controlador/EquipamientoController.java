package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Servicio.EquipamientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipamiento")
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService) {
        this.equipamientoService = equipamientoService;
    }

    @GetMapping
    public ResponseEntity<List<EquipamientoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(equipamientoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamientoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return equipamientoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EquipamientoResponseDTO>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(equipamientoService.buscarPorNombre(nombre));
    }

    @GetMapping("/con-stock")
    public ResponseEntity<List<EquipamientoResponseDTO>> buscarConStock() {
        return ResponseEntity.ok(equipamientoService.buscarConStock());
    }

    @PostMapping
    public ResponseEntity<EquipamientoResponseDTO> guardar(@Valid @RequestBody EquipamientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamientoService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamientoResponseDTO> actualizar(@PathVariable Integer id,
                                                              @Valid @RequestBody EquipamientoRequestDTO dto) {
        return ResponseEntity.ok(equipamientoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        equipamientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
