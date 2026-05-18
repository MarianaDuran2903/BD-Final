package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query(value = "SELECT * FROM plan", nativeQuery = true)
    List<Plan> findAll();

    @Query(value = "SELECT * FROM plan WHERE id_plan = :id", nativeQuery = true)
    Optional<Plan> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Plan p WHERE p.idPlan = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM plan WHERE duracion = :duracion", nativeQuery = true)
    List<Plan> findByDuracion(@Param("duracion") DuracionPlan duracion);

    @Query(value = "SELECT * FROM plan WHERE duracion = :duracion ORDER BY precio ASC LIMIT 1", nativeQuery = true)
    Optional<Plan> findFirstByDuracionOrderByPrecioAsc(@Param("duracion") DuracionPlan duracion);
}