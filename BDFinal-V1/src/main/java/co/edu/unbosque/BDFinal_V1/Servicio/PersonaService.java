package co.edu.unbosque.BDFinal_V1.Servicio;

public interface PersonaService {
    List<Persona> listarTodos();
    Optional<Persona> buscarPorCedula(String cedula);
    Persona guardar(Persona persona);
    Persona actualizar(String cedula, Persona persona);
    void eliminar(String cedula);
}
