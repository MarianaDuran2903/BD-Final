package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> listarTodos();

    Optional<Persona> buscarPorCedula(String cedula);

    Optional<Persona> buscarPorCorreo(String correo);

    Persona guardar(Persona persona);

    Persona actualizar(String cedula, Persona persona);

    void eliminar(String cedula);

    List<Persona> buscarPorRol(Rol rol);

    boolean existeCorreo(String correo);
}
