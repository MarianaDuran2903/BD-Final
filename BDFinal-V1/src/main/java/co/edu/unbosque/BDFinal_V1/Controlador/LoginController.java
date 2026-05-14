package co.edu.unbosque.BDFinal_V1.Controlador;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.*;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EntrenadorService;
import co.edu.unbosque.BDFinal_V1.Servicio.MiembroService;
import co.edu.unbosque.BDFinal_V1.Servicio.OperadorService;
import co.edu.unbosque.BDFinal_V1.Servicio.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final PersonaRepository personaRepository;
    private final MiembroService miembroService;
    private final EntrenadorService entrenadorService;
    private final OperadorService operadorService;
    private final PersonaService personaService;

    public LoginController(PersonaRepository personaRepository,
                           MiembroService miembroService,
                           EntrenadorService entrenadorService,
                           OperadorService operadorService, PersonaService personaService) {

        this.personaRepository = personaRepository;
        this.miembroService = miembroService;
        this.entrenadorService = entrenadorService;
        this.operadorService = operadorService;
        this.personaService = personaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO request) {

        var optPersona = personaRepository.findByCorreo(request.getCorreo());

        if (optPersona.isEmpty() ||
                !optPersona.get().getPassword().equals(request.getPassword())) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales incorrectas"));
        }

        Persona persona = optPersona.get();

        String token = UUID.randomUUID().toString();

        Object perfilCompleto = switch (persona.getRol()) {

            case miembro -> miembroService.buscarPorCedula(persona.getCedula())
                    .orElseThrow(() ->
                            new RuntimeException("Perfil de miembro no encontrado"));

            case entrenador -> entrenadorService.buscarPorCedula(persona.getCedula())
                    .orElseThrow(() ->
                            new RuntimeException("Perfil de entrenador no encontrado"));

            case operador -> operadorService.buscarPorCedula(persona.getCedula())
                    .orElseThrow(() ->
                            new RuntimeException("Perfil de operador no encontrado"));

            case administrador -> personaService.buscarPorCedula(persona.getCedula())
                    .orElseThrow(() ->
                            new RuntimeException("Administrador no encontrado"));
        };

        String nombreCompleto =
                persona.getPrimerNombre()
                        + (persona.getSegundoNombre() != null
                        ? " " + persona.getSegundoNombre()
                        : "")
                        + " "
                        + persona.getPrimerApellido()
                        + " "
                        + persona.getSegundoApellido();

        LoginResponseDTO response = new LoginResponseDTO(
                persona.getCedula(),
                nombreCompleto,
                persona.getCorreo(),
                persona.getRol(),
                perfilCompleto,
                token
        );

        return ResponseEntity.ok(response);
    }
}