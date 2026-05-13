package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import co.edu.unbosque.BDFinal_V1.Servicio.HorarioService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public ResponseEntity<List<HorarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(horarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioResponseDTO> buscarPorId(@PathVariable Integer id) {
        return horarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<HorarioResponseDTO>> buscarPorFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(horarioService.buscarPorFecha(fecha));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<HorarioResponseDTO>> buscarDisponibles() {
        return ResponseEntity.ok(horarioService.buscarDisponibles());
    }

    @GetMapping("/rango")
    public ResponseEntity<List<HorarioResponseDTO>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(horarioService.buscarPorRangoFechas(inicio, fin));
    }

    @PostMapping
    public ResponseEntity<HorarioResponseDTO> guardar(@Valid @RequestBody HorarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioResponseDTO> actualizar(@PathVariable Integer id,
                                                         @Valid @RequestBody HorarioRequestDTO dto) {
        return ResponseEntity.ok(horarioService.actualizar(id, dto));
    }

    @PatchMapping("/{id}/disponibilidad")
    public ResponseEntity<HorarioResponseDTO> cambiarDisponibilidad(@PathVariable Integer id,
                                                                     @RequestParam DisponibilidadHorario valor) {
        return ResponseEntity.ok(horarioService.cambiarDisponibilidad(id, valor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        horarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
