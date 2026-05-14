package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoRepository extends JpaRepository<PlanEntrenamiento, String> {

    @Query(value = "SELECT * FROM PLAN_ENTRENAMIENTO", nativeQuery = true)
    List<PlanEntrenamiento> findAll();

    @Query(value = "SELECT * FROM PLAN_ENTRENAMIENTO WHERE MIEMBRO_cedula = :id", nativeQuery = true)
    Optional<PlanEntrenamiento> findById(@Param("id") String id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PlanEntrenamiento p WHERE p.miembroCedula = :id")
    boolean existsById(@Param("id") String id);

    @Query(value = "SELECT * FROM PLAN_ENTRENAMIENTO WHERE MIEMBRO_cedula = :cedula", nativeQuery = true)
    Optional<PlanEntrenamiento> findByMiembro_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM PLAN_ENTRENAMIENTO WHERE ENTRENADOR_cedula = :cedula", nativeQuery = true)
    List<PlanEntrenamiento> findByEntrenador_Cedula(@Param("cedula") String cedula);

    boolean existsByMiembro_Cedula(String cedula);
}