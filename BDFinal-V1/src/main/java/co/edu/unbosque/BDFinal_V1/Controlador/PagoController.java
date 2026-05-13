package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import co.edu.unbosque.BDFinal_V1.Servicio.PagoService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pagoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponseDTO> buscarPorId(@PathVariable Integer id) {
        return pagoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/miembro/{cedula}")
    public ResponseEntity<List<PagoResponseDTO>> historialPorMiembro(@PathVariable String cedula) {
        return ResponseEntity.ok(pagoService.historialPorMiembro(cedula));
    }

    @GetMapping("/metodo/{metodo}")
    public ResponseEntity<List<PagoResponseDTO>> buscarPorMetodoPago(@PathVariable MetodoPago metodo) {
        return ResponseEntity.ok(pagoService.buscarPorMetodoPago(metodo));
    }

    @GetMapping("/rango")
    public ResponseEntity<List<PagoResponseDTO>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(pagoService.buscarPorRangoFechas(inicio, fin));
    }

    @PostMapping
    public ResponseEntity<PagoResponseDTO> registrar(@Valid @RequestBody PagoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.registrar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
