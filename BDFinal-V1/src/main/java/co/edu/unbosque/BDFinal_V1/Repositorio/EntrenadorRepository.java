package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface EntrenadorRepository extends JpaRepository<Entrenador, String> {

    @Query(value = "SELECT * FROM ENTRENADOR", nativeQuery = true)
    List<Entrenador> findAll();

    @Query(value = "SELECT * FROM ENTRENADOR WHERE cedula = :id", nativeQuery = true)
    Optional<Entrenador> findById(@Param("id") String id);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Entrenador e WHERE e.cedula = :id")
    boolean existsById(@Param("id") String id);

    @Query(value = "SELECT * FROM ENTRENADOR WHERE tipo_entrenamiento = :tipo", nativeQuery = true)
    List<Entrenador> findByTipoEntrenamiento(@Param("tipo") TipoEntrenamiento tipo);

    @Query(value = "SELECT * FROM ENTRENADOR WHERE nivel_exigencia = :nivel", nativeQuery = true)
    List<Entrenador> findByNivelExigencia(@Param("nivel") NivelExigencia nivel);

    @Query(value = "SELECT e.* FROM ENTRENADOR e JOIN Especializar esp ON e.cedula = esp.ENTRENADOR_cedula WHERE esp.DEPORTE_id_deporte = :idDeporte", nativeQuery = true)
    List<Entrenador> findByDeportes_IdDeporte(@Param("idDeporte") Integer idDeporte);

    boolean existsByCedula(String cedula);

    @Modifying
    @Query(value = "DELETE FROM ENTRENADOR WHERE cedula = :cedula", nativeQuery = true)
    void deleteByCedula(@Param("cedula") String cedula);
}