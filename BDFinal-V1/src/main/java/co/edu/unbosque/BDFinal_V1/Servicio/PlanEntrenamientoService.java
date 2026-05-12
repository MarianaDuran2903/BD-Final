package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoService {

    Optional<PlanEntrenamiento> buscarPorMiembro(String cedula);

    PlanEntrenamiento asignarRutina(PlanEntrenamiento plan);

    PlanEntrenamiento actualizarRutina(String cedula, PlanEntrenamiento plan);

    void eliminarRutina(String cedula);

    boolean tienePlanAsignado(String cedula);

    List<PlanEntrenamiento> buscarPorEntrenador(String cedula);
}
