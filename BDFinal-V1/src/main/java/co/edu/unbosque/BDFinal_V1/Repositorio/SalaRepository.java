package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

    @Query(value = "SELECT * FROM sala", nativeQuery = true)
    List<Sala> findAll();

    @Query(value = "SELECT * FROM sala WHERE id_sala = :id", nativeQuery = true)
    Optional<Sala> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Sala s WHERE s.idSala = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM sala WHERE capacidad >= :capacidad", nativeQuery = true)
    List<Sala> findByCapacidadGreaterThanEqual(@Param("capacidad") Short capacidad);
}