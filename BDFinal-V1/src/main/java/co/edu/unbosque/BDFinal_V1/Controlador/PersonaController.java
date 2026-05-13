package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Servicio.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<PersonaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(personaService.listarTodos());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<PersonaResponseDTO> buscarPorCedula(@PathVariable String cedula) {
        return personaService.buscarPorCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<PersonaResponseDTO> buscarPorCorreo(@PathVariable String correo) {
        return personaService.buscarPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<PersonaResponseDTO>> buscarPorRol(@PathVariable Rol rol) {
        return ResponseEntity.ok(personaService.buscarPorRol(rol));
    }

    @GetMapping("/existe-correo")
    public ResponseEntity<Boolean> existeCorreo(@RequestParam String correo) {
        return ResponseEntity.ok(personaService.existeCorreo(correo));
    }

    @PostMapping
    public ResponseEntity<PersonaResponseDTO> guardar(@Valid @RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.guardar(dto));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<PersonaResponseDTO> actualizar(@PathVariable String cedula,
                                                         @Valid @RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.ok(personaService.actualizar(cedula, dto));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        personaService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}
