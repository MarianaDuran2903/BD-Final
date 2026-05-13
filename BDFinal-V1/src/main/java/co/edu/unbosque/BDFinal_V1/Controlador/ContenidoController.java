package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import co.edu.unbosque.BDFinal_V1.Servicio.ContenidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    private final ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @GetMapping
    public ResponseEntity<List<ContenidoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(contenidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return contenidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/deporte/{idDeporte}")
    public ResponseEntity<List<ContenidoResponseDTO>> buscarPorDeporte(@PathVariable Integer idDeporte) {
        return ResponseEntity.ok(contenidoService.buscarPorDeporte(idDeporte));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ContenidoResponseDTO>> buscarPorTipo(@PathVariable TipoContenido tipo) {
        return ResponseEntity.ok(contenidoService.buscarPorTipo(tipo));
    }

    @PostMapping
    public ResponseEntity<ContenidoResponseDTO> guardar(@Valid @RequestBody ContenidoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contenidoService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoResponseDTO> actualizar(@PathVariable Integer id,
                                                           @Valid @RequestBody ContenidoRequestDTO dto) {
        return ResponseEntity.ok(contenidoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        contenidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
