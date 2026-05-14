package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.DeporteRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EntrenadorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;
    private final PersonaRepository personaRepository;
    private final DeporteRepository deporteRepository;
    private final ModelMapper mm = new ModelMapper();

    public EntrenadorServiceImpl(EntrenadorRepository entrenadorRepository,
                                 PersonaRepository personaRepository,
                                 DeporteRepository deporteRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.personaRepository = personaRepository;
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntrenadorResponseDTO> listarTodos() {
        return entrenadorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EntrenadorResponseDTO> buscarPorCedula(String cedula) {
        return entrenadorRepository.findById(cedula).map(this::toResponseDTO);
    }

    @Override
    public EntrenadorResponseDTO guardar(EntrenadorRequestDTO dto) {
        if (personaRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Ya existe una persona con el correo: " + dto.getCorreo());
        }
        Persona persona = mm.map(dto, Persona.class);
        persona.setRol(Rol.entrenador);
        Persona savedPersona = personaRepository.save(persona);

        Entrenador entrenador = new Entrenador();
        entrenador.setPersona(savedPersona);
        entrenador.setTipoEntrenamiento(dto.getTipoEntrenamiento());
        entrenador.setTiempoExperiencia(dto.getTiempoExperiencia());
        entrenador.setNivelExigencia(dto.getNivelExigencia());
        entrenador.setFechaIngresoSis(dto.getFechaIngresoSis());

        if (dto.getDeportesIds() != null && !dto.getDeportesIds().isEmpty()) {
            List<Deporte> deportes = dto.getDeportesIds().stream()
                    .map(id -> deporteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Deporte no encontrado: " + id)))
                    .collect(Collectors.toList());
            entrenador.setDeportes(deportes);
        }
        return toResponseDTO(entrenadorRepository.save(entrenador));
    }

    @Override
    public EntrenadorResponseDTO actualizar(String cedula, EntrenadorRequestDTO dto) {
        Persona persona = personaRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con cédula: " + cedula));
        persona.setTelefono(dto.getTelefono());
        persona.setCorreo(dto.getCorreo());
        persona.setPassword(dto.getPassword());
        persona.setPrimerNombre(dto.getPrimerNombre());
        persona.setSegundoNombre(dto.getSegundoNombre());
        persona.setPrimerApellido(dto.getPrimerApellido());
        persona.setSegundoApellido(dto.getSegundoApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        personaRepository.save(persona);

        Entrenador entrenador = entrenadorRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con cédula: " + cedula));
        entrenador.setTipoEntrenamiento(dto.getTipoEntrenamiento());
        entrenador.setTiempoExperiencia(dto.getTiempoExperiencia());
        entrenador.setNivelExigencia(dto.getNivelExigencia());
        entrenador.setFechaIngresoSis(dto.getFechaIngresoSis());

        if (dto.getDeportesIds() != null) {
            List<Deporte> deportes = dto.getDeportesIds().stream()
                    .map(id -> deporteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Deporte no encontrado: " + id)))
                    .collect(Collectors.toList());
            entrenador.setDeportes(deportes);
        }
        return toResponseDTO(entrenadorRepository.save(entrenador));
    }

    @Override
    public void eliminar(String cedula) {
        if (!entrenadorRepository.existsById(cedula)) {
            throw new RuntimeException("Entrenador no encontrado con cédula: " + cedula);
        }
        entrenadorRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntrenadorResponseDTO> buscarPorTipoEntrenamiento(TipoEntrenamiento tipo) {
        return entrenadorRepository.findByTipoEntrenamiento(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntrenadorResponseDTO> buscarPorNivelExigencia(NivelExigencia nivel) {
        return entrenadorRepository.findByNivelExigencia(nivel).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntrenadorResponseDTO> buscarPorDeporte(Integer idDeporte) {
        return entrenadorRepository.findByDeportes_IdDeporte(idDeporte).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeEntrenador(String cedula) {
        return entrenadorRepository.existsById(cedula);
    }

    private EntrenadorResponseDTO toResponseDTO(Entrenador e) {
        EntrenadorResponseDTO dto = new EntrenadorResponseDTO();
        Persona p = e.getPersona();
        if (p != null) {
            dto.setCedula(p.getCedula());
            dto.setTelefono(p.getTelefono());
            dto.setCorreo(p.getCorreo());
            dto.setPrimerNombre(p.getPrimerNombre());
            dto.setSegundoNombre(p.getSegundoNombre());
            dto.setPrimerApellido(p.getPrimerApellido());
            dto.setSegundoApellido(p.getSegundoApellido());
            dto.setFechaNacimiento(p.getFechaNacimiento());
            dto.setRol(p.getRol());
        }
        dto.setTipoEntrenamiento(e.getTipoEntrenamiento());
        dto.setTiempoExperiencia(e.getTiempoExperiencia());
        dto.setNivelExigencia(e.getNivelExigencia());
        dto.setFechaIngresoSis(e.getFechaIngresoSis());
        if (e.getDeportes() != null) {
            dto.setDeportes(e.getDeportes().stream()
                    .map(d -> mm.map(d, DeporteResponseDTO.class))
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
