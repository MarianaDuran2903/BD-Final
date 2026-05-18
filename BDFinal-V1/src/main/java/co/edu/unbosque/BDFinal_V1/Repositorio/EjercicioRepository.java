package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {

    @Query(value = "SELECT * FROM ejercicio", nativeQuery = true)
    List<Ejercicio> findAll();

    @Query(value = "SELECT * FROM ejercicio WHERE id_ejercicio = :id", nativeQuery = true)
    Optional<Ejercicio> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Ejercicio e WHERE e.idEjercicio = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM ejercicio WHERE PLAN_ENTRENAMIENTO_id_asignacion = :idAsignacion", nativeQuery = true)
    List<Ejercicio> findByPlanEntrenamiento_IdAsignacion(@Param("idAsignacion") Integer idAsignacion);
}
