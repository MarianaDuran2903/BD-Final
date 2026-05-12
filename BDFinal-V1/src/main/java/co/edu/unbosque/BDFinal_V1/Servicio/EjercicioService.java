package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Ejercicio;
import java.util.List;
import java.util.Optional;

public interface EjercicioService {

    List<Ejercicio> listarTodos();

    Optional<Ejercicio> buscarPorId(Integer id);

    Ejercicio guardar(Ejercicio ejercicio);

    Ejercicio actualizar(Integer id, Ejercicio ejercicio);

    void eliminar(Integer id);

    List<Ejercicio> buscarPorPlanDeMiembro(String cedula);
}
