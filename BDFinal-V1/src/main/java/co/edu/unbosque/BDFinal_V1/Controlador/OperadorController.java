package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import co.edu.unbosque.BDFinal_V1.Servicio.OperadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/operadores")
public class OperadorController {

    private final OperadorService operadorService;

    public OperadorController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }

    @GetMapping
    public ResponseEntity<List<OperadorResponseDTO>> listarTodos() {
        return ResponseEntity.ok(operadorService.listarTodos());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<OperadorResponseDTO> buscarPorCedula(@PathVariable String cedula) {
        return operadorService.buscarPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<OperadorResponseDTO>> buscarPorTipo(@PathVariable TipoOperador tipo) {
        return ResponseEntity.ok(operadorService.buscarPorTipoOperador(tipo));
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<OperadorResponseDTO>> buscarPorEspecialidad(@PathVariable EspecialidadOperador especialidad) {
        return ResponseEntity.ok(operadorService.buscarPorEspecialidad(especialidad));
    }

    @PostMapping
    public ResponseEntity<OperadorResponseDTO> guardar(@Valid @RequestBody OperadorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(operadorService.guardar(dto));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<OperadorResponseDTO> actualizar(@PathVariable String cedula,
                                                          @Valid @RequestBody OperadorRequestDTO dto) {
        return ResponseEntity.ok(operadorService.actualizar(cedula, dto));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        operadorService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}
