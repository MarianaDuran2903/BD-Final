package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DiaSemana;
import co.edu.unbosque.BDFinal_V1.Servicio.HorarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/dia/{dia}")
    public ResponseEntity<List<HorarioResponseDTO>> buscarPorDia(@PathVariable DiaSemana dia) {
        return ResponseEntity.ok(horarioService.buscarPorDia(dia));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        horarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}