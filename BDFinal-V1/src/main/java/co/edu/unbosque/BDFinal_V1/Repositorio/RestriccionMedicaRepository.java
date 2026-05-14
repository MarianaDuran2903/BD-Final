package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.RestriccionMedica;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface RestriccionMedicaRepository extends JpaRepository<RestriccionMedica, Integer> {

    @Query(value = "SELECT * FROM Restriccion_medica", nativeQuery = true)
    List<RestriccionMedica> findAll();

    @Query(value = "SELECT * FROM Restriccion_medica WHERE id_restriccion = :id", nativeQuery = true)
    Optional<RestriccionMedica> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RestriccionMedica r WHERE r.idRestriccion = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Restriccion_medica WHERE MIEMBRO_cedula = :cedula", nativeQuery = true)
    List<RestriccionMedica> findByMiembro_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM Restriccion_medica WHERE nivel_gravedad = :nivel", nativeQuery = true)
    List<RestriccionMedica> findByNivelGravedad(@Param("nivel") NivelGravedad nivel);

    @Query(value = "SELECT * FROM Restriccion_medica WHERE tipo = :tipo", nativeQuery = true)
    List<RestriccionMedica> findByTipo(@Param("tipo") TipoRestriccion tipo);
}