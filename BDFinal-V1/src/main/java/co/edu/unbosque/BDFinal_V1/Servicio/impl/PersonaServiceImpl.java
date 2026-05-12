package co.edu.unbosque.BDFinal_V1.Servicio.impl;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> listarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> buscarPorCedula(String cedula) {
        return personaRepository.findById(cedula);
    }

    @Override
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizar(String cedula, Persona persona) {
        persona.setCedula(cedula);
        return personaRepository.save(persona);
    }

    @Override
    public void eliminar(String cedula) {
        personaRepository.deleteById(cedula);
    }
}
