package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoRepository extends JpaRepository<PlanEntrenamiento, String> {

    Optional<PlanEntrenamiento> findByMiembro_Cedula(String cedula);

    List<PlanEntrenamiento> findByEntrenador_Cedula(String cedula);

    boolean existsByMiembro_Cedula(String cedula);
}
