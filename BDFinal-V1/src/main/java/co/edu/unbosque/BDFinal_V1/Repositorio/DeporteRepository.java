package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface DeporteRepository extends JpaRepository<Deporte, Integer> {

    @Query(value = "SELECT * FROM deporte", nativeQuery = true)
    List<Deporte> findAll();

    @Query(value = "SELECT * FROM deporte WHERE id_deporte = :id", nativeQuery = true)
    Optional<Deporte> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM Deporte d WHERE d.idDeporte = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM deporte WHERE nombre = :nombre", nativeQuery = true)
    Optional<Deporte> findByNombre(@Param("nombre") String nombre);

    boolean existsByNombre(String nombre);
}