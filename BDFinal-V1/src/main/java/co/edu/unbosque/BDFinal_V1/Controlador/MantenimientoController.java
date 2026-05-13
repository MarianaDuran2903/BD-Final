package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import co.edu.unbosque.BDFinal_V1.Servicio.MantenimientoService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping
    public ResponseEntity<List<MantenimientoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(mantenimientoService.listarTodos());
    }

    @GetMapping("/{cedula}/{codigoSerie}")
    public ResponseEntity<MantenimientoResponseDTO> buscarPorId(@PathVariable String cedula,
                                                                @PathVariable Integer codigoSerie) {
        return mantenimientoService.buscarPorId(new MantenimientoId(cedula, codigoSerie))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/operador/{cedula}")
    public ResponseEntity<List<MantenimientoResponseDTO>> buscarPorOperador(@PathVariable String cedula) {
        return ResponseEntity.ok(mantenimientoService.buscarPorOperador(cedula));
    }

    @GetMapping("/maquina/{codigoSerie}")
    public ResponseEntity<List<MantenimientoResponseDTO>> buscarPorMaquina(@PathVariable Integer codigoSerie) {
        return ResponseEntity.ok(mantenimientoService.buscarPorMaquina(codigoSerie));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MantenimientoResponseDTO>> buscarPorTipo(@PathVariable TipoMantenimiento tipo) {
        return ResponseEntity.ok(mantenimientoService.buscarPorTipo(tipo));
    }

    @GetMapping("/rango")
    public ResponseEntity<List<MantenimientoResponseDTO>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(mantenimientoService.buscarPorRangoFechas(inicio, fin));
    }

    @PostMapping
    public ResponseEntity<MantenimientoResponseDTO> registrar(@Valid @RequestBody MantenimientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mantenimientoService.registrar(dto));
    }

    @DeleteMapping("/{cedula}/{codigoSerie}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula,
                                         @PathVariable Integer codigoSerie) {
        mantenimientoService.eliminar(new MantenimientoId(cedula, codigoSerie));
        return ResponseEntity.noContent().build();
    }
}
