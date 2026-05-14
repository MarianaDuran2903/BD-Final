package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    @Query(value = "SELECT * FROM CLASE", nativeQuery = true)
    List<Clase> findAll();

    @Query(value = "SELECT * FROM CLASE WHERE id_clase = :id", nativeQuery = true)
    Optional<Clase> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Clase c WHERE c.idClase = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM CLASE WHERE ENTRENADOR_cedula = :cedula", nativeQuery = true)
    List<Clase> findByEntrenador_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM CLASE WHERE DEPORTE_id_deporte = :idDeporte", nativeQuery = true)
    List<Clase> findByDeporte_IdDeporte(@Param("idDeporte") Integer idDeporte);

    @Query(value = "SELECT * FROM CLASE WHERE estado = :estado", nativeQuery = true)
    List<Clase> findByEstado(@Param("estado") EstadoClase estado);

    @Query(value = "SELECT * FROM CLASE WHERE Sala_id_sala = :idSala", nativeQuery = true)
    List<Clase> findBySala_IdSala(@Param("idSala") Integer idSala);
}