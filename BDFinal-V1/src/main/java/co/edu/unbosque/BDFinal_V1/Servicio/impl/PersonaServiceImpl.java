package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final ModelMapper mm = new ModelMapper();

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaResponseDTO> listarTodos() {
        return personaRepository.findAll().stream()
                .map(p -> mm.map(p, PersonaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonaResponseDTO> buscarPorCedula(String cedula) {
        return personaRepository.findById(cedula)
                .map(p -> mm.map(p, PersonaResponseDTO.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonaResponseDTO> buscarPorCorreo(String correo) {
        return personaRepository.findByCorreo(correo)
                .map(p -> mm.map(p, PersonaResponseDTO.class));
    }

    @Override
    public PersonaResponseDTO guardar(PersonaRequestDTO dto) {
        if (personaRepository.existsByCorreo(dto.getCorreo())) {
            throw new IllegalArgumentException("Ya existe una persona con el correo: " + dto.getCorreo());
        }
        Persona persona = mm.map(dto, Persona.class);
        return mm.map(personaRepository.save(persona), PersonaResponseDTO.class);
    }

    @Override
    public PersonaResponseDTO actualizar(String cedula, PersonaRequestDTO dto) {
        if (!personaRepository.existsById(cedula)) {
            throw new RuntimeException("Persona no encontrada con cédula: " + cedula);
        }
        Persona persona = mm.map(dto, Persona.class);
        persona.setCedula(cedula);
        return mm.map(personaRepository.save(persona), PersonaResponseDTO.class);
    }

    @Override
    public void eliminar(String cedula) {
        if (!personaRepository.existsById(cedula)) {
            throw new RuntimeException("Persona no encontrada con cédula: " + cedula);
        }
        personaRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaResponseDTO> buscarPorRol(Rol rol) {
        return personaRepository.findByRol(rol).stream()
                .map(p -> mm.map(p, PersonaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCorreo(String correo) {
        return personaRepository.existsByCorreo(correo);
    }
}
