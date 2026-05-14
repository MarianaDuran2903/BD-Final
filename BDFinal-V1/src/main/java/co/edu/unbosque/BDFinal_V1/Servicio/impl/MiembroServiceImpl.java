package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.*;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MiembroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MiembroServiceImpl implements MiembroService {

    private final MiembroRepository miembroRepository;
    private final PersonaRepository personaRepository;
    private final ModelMapper mm = new ModelMapper();

    public MiembroServiceImpl(MiembroRepository miembroRepository,
                              PersonaRepository personaRepository) {
        this.miembroRepository = miembroRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiembroResponseDTO> listarTodos() {
        return miembroRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MiembroResponseDTO> buscarPorCedula(String cedula) {
        return miembroRepository.findById(cedula)
                .map(this::toResponseDTO);
    }

    @Override
    public MiembroResponseDTO guardar(MiembroRequestDTO dto) {
        if (personaRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Ya existe una persona con el correo: " + dto.getCorreo());
        }
        Persona persona = mm.map(dto, Persona.class);
        persona.setRol(Rol.miembro);
        Persona savedPersona = personaRepository.save(persona);

        Miembro miembro = new Miembro();
        miembro.setPersona(savedPersona);
        miembro.setAltura(dto.getAltura());
        miembro.setPesoActual(dto.getPesoActual());
        miembro.setNivelExperiencia(dto.getNivelExperiencia());
        return toResponseDTO(miembroRepository.save(miembro));
    }

    @Override
    public MiembroResponseDTO actualizar(String cedula, MiembroRequestDTO dto) {
        Persona persona = personaRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado con cédula: " + cedula));
        persona.setTelefono(dto.getTelefono());
        persona.setCorreo(dto.getCorreo());
        persona.setPassword(dto.getPassword());
        persona.setPrimerNombre(dto.getPrimerNombre());
        persona.setSegundoNombre(dto.getSegundoNombre());
        persona.setPrimerApellido(dto.getPrimerApellido());
        persona.setSegundoApellido(dto.getSegundoApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        personaRepository.save(persona);

        Miembro miembro = miembroRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado con cédula: " + cedula));
        miembro.setAltura(dto.getAltura());
        miembro.setPesoActual(dto.getPesoActual());
        miembro.setNivelExperiencia(dto.getNivelExperiencia());
        return toResponseDTO(miembroRepository.save(miembro));
    }

    @Override
    public void eliminar(String cedula) {
        if (!miembroRepository.existsById(cedula)) {
            throw new RuntimeException("Miembro no encontrado con cédula: " + cedula);
        }
        miembroRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiembroResponseDTO> buscarPorNivelExperiencia(NivelExperiencia nivel) {
        return miembroRepository.findByNivelExperiencia(nivel).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiembroResponseDTO> buscarPorRangoAltura(Short min, Short max) {
        return miembroRepository.findByAlturaBetween(min, max).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiembroResponseDTO> buscarPorRangoPeso(BigDecimal min, BigDecimal max) {
        return miembroRepository.findByPesoActualBetween(min, max).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeMiembro(String cedula) {
        return miembroRepository.existsById(cedula);
    }

    private MiembroResponseDTO toResponseDTO(Miembro m) {
        MiembroResponseDTO dto = new MiembroResponseDTO();
        Persona p = m.getPersona();
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
        dto.setAltura(m.getAltura());
        dto.setPesoActual(m.getPesoActual());
        dto.setNivelExperiencia(m.getNivelExperiencia());

        m.getMembresias().stream()
                .filter(mem -> mem.getEstado() == EstadoMembresia.activa)
                .findFirst()
                .ifPresent(mem -> {
                    dto.setMembresiaEstado(mem.getEstado());
                    if (mem.getPlan() != null) {
                        dto.setPlanNombre(mem.getPlan().getDuracion().name());
                    }
                });

        if (!m.getRestriccionesMedicas().isEmpty()) {
            dto.setRestriccionesMedicas(m.getRestriccionesMedicas().stream()
                    .map(r -> mm.map(r, RestriccionMedicaResponseDTO.class))
                    .collect(Collectors.toList()));
        }

        if (m.getPlanEntrenamiento() != null) {
            PlanEntrenamientoResponseDTO pe = new PlanEntrenamientoResponseDTO();
            pe.setMiembroCedula(m.getCedula());
            pe.setDescripcion(m.getPlanEntrenamiento().getDescripcion());
            if (m.getPlanEntrenamiento().getEntrenador() != null) {
                Persona ep = m.getPlanEntrenamiento().getEntrenador().getPersona();
                if (ep != null) {
                    pe.setNombreEntrenador(ep.getPrimerNombre() + " " + ep.getPrimerApellido());
                }
            }
            dto.setPlanEntrenamiento(pe);
        }
        return dto;
    }
}
