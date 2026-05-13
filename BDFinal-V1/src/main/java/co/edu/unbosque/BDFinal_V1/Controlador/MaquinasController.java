package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import co.edu.unbosque.BDFinal_V1.Servicio.MaquinasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinasController {

    private final MaquinasService maquinasService;

    public MaquinasController(MaquinasService maquinasService) {
        this.maquinasService = maquinasService;
    }

    @GetMapping
    public ResponseEntity<List<MaquinasResponseDTO>> listarTodas() {
        return ResponseEntity.ok(maquinasService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaquinasResponseDTO> buscarPorId(@PathVariable Integer id) {
        return maquinasService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MaquinasResponseDTO>> buscarPorTipo(@PathVariable TipoMaquina tipo) {
        return ResponseEntity.ok(maquinasService.buscarPorTipo(tipo));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<MaquinasResponseDTO>> buscarPorEstado(@PathVariable EstadoMaquina estado) {
        return ResponseEntity.ok(maquinasService.buscarPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<MaquinasResponseDTO> guardar(@Valid @RequestBody MaquinasRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maquinasService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaquinasResponseDTO> actualizar(@PathVariable Integer id,
                                                          @Valid @RequestBody MaquinasRequestDTO dto) {
        return ResponseEntity.ok(maquinasService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<MaquinasResponseDTO> cambiarEstado(@PathVariable Integer id,
                                                             @RequestParam EstadoMaquina valor) {
        return ResponseEntity.ok(maquinasService.cambiarEstado(id, valor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        maquinasService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
