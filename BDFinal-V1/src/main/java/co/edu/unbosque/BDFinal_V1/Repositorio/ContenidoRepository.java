package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Contenido;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    @Query(value = "SELECT * FROM contenido", nativeQuery = true)
    List<Contenido> findAll();

    @Query(value = "SELECT * FROM contenido WHERE id_contenido = :id", nativeQuery = true)
    Optional<Contenido> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contenido c WHERE c.idContenido = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM contenido WHERE DEPORTE_id_deporte = :idDeporte", nativeQuery = true)
    List<Contenido> findByDeporte_IdDeporte(@Param("idDeporte") Integer idDeporte);

    @Query(value = "SELECT * FROM contenido WHERE tipo_contenido = :tipo", nativeQuery = true)
    List<Contenido> findByTipoContenido(@Param("tipo") TipoContenido tipo);

    @Query(value = "SELECT * FROM contenido WHERE autor = :autor", nativeQuery = true)
    List<Contenido> findByAutor(@Param("autor") String autor);

    @Query(value = "SELECT * FROM contenido WHERE fecha_publicacion BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Contenido> findByFechaPublicacionBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);
}