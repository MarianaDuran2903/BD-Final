package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Repositorio.PersonaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarTodos() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorCedula(String cedula) {
        return personaRepository.findById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorCorreo(String correo) {
        return personaRepository.findByCorreo(correo);
    }

    @Override
    public Persona guardar(Persona persona) {
        if (personaRepository.existsByCorreo(persona.getCorreo())) {
            throw new IllegalArgumentException("Ya existe una persona con el correo: " + persona.getCorreo());
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizar(String cedula, Persona persona) {
        if (!personaRepository.existsById(cedula)) {
            throw new RuntimeException("Persona no encontrada con cédula: " + cedula);
        }
        persona.setCedula(cedula);
        return personaRepository.save(persona);
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
    public List<Persona> buscarPorRol(Rol rol) {
        return personaRepository.findByRol(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCorreo(String correo) {
        return personaRepository.existsByCorreo(correo);
    }
}
