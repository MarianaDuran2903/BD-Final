package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoRepository extends JpaRepository<PlanEntrenamiento, Integer> {

    Optional<PlanEntrenamiento> findByAsignacion_IdAsignacion(Integer idAsignacion);

    List<PlanEntrenamiento> findByAsignacion_Entrenador_Cedula(String cedula);

    List<PlanEntrenamiento> findByAsignacion_Miembro_Cedula(String cedula);

    boolean existsByAsignacion_IdAsignacion(Integer idAsignacion);
}
