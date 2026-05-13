package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import co.edu.unbosque.BDFinal_V1.Repositorio.OperadorRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.OperadorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OperadorServiceImpl implements OperadorService {

    private final OperadorRepository operadorRepository;
    private final PersonaRepository personaRepository;
    private final ModelMapper mm = new ModelMapper();

    public OperadorServiceImpl(OperadorRepository operadorRepository,
                               PersonaRepository personaRepository) {
        this.operadorRepository = operadorRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OperadorResponseDTO> listarTodos() {
        return operadorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OperadorResponseDTO> buscarPorCedula(String cedula) {
        return operadorRepository.findById(cedula).map(this::toResponseDTO);
    }

    @Override
    public OperadorResponseDTO guardar(OperadorRequestDTO dto) {
        if (personaRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Ya existe una persona con el correo: " + dto.getCorreo());
        }
        Persona persona = mm.map(dto, Persona.class);
        persona.setRol(Rol.operador);
        Persona savedPersona = personaRepository.save(persona);

        Operador operador = new Operador();
        operador.setCedula(savedPersona.getCedula());
        operador.setPersona(savedPersona);
        operador.setNivelTecnico(dto.getNivelTecnico());
        operador.setEspecialidad(dto.getEspecialidad());
        operador.setTipoOperador(dto.getTipoOperador());
        return toResponseDTO(operadorRepository.save(operador));
    }

    @Override
    public OperadorResponseDTO actualizar(String cedula, OperadorRequestDTO dto) {
        Persona persona = personaRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Operador no encontrado con cédula: " + cedula));
        persona.setTelefono(dto.getTelefono());
        persona.setCorreo(dto.getCorreo());
        persona.setPassword(dto.getPassword());
        persona.setPrimerNombre(dto.getPrimerNombre());
        persona.setSegundoNombre(dto.getSegundoNombre());
        persona.setPrimerApellido(dto.getPrimerApellido());
        persona.setSegundoApellido(dto.getSegundoApellido());
        persona.setFechaNacimiento(dto.getFechaNacimiento());
        personaRepository.save(persona);

        Operador operador = operadorRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Operador no encontrado con cédula: " + cedula));
        operador.setNivelTecnico(dto.getNivelTecnico());
        operador.setEspecialidad(dto.getEspecialidad());
        operador.setTipoOperador(dto.getTipoOperador());
        return toResponseDTO(operadorRepository.save(operador));
    }

    @Override
    public void eliminar(String cedula) {
        if (!operadorRepository.existsById(cedula)) {
            throw new RuntimeException("Operador no encontrado con cédula: " + cedula);
        }
        operadorRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OperadorResponseDTO> buscarPorTipoOperador(TipoOperador tipo) {
        return operadorRepository.findByTipoOperador(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OperadorResponseDTO> buscarPorEspecialidad(EspecialidadOperador especialidad) {
        return operadorRepository.findByEspecialidad(especialidad).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private OperadorResponseDTO toResponseDTO(Operador o) {
        OperadorResponseDTO dto = new OperadorResponseDTO();
        Persona p = o.getPersona();
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
        dto.setNivelTecnico(o.getNivelTecnico());
        dto.setEspecialidad(o.getEspecialidad());
        dto.setTipoOperador(o.getTipoOperador());
        return dto;
    }
}
