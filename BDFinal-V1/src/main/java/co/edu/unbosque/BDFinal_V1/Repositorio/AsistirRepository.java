package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Asistir;
import co.edu.unbosque.BDFinal_V1.Modelo.AsistirId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface AsistirRepository extends JpaRepository<Asistir, AsistirId> {

    @Query(value = "SELECT * FROM Asistir", nativeQuery = true)
    List<Asistir> findAll();

    @Query("SELECT a FROM Asistir a WHERE a.id = :id")
    Optional<Asistir> findById(@Param("id") AsistirId id);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Asistir a WHERE a.id = :id")
    boolean existsById(@Param("id") AsistirId id);

    @Query(value = "SELECT * FROM Asistir WHERE MIEMBRO_cedula = :cedula", nativeQuery = true)
    List<Asistir> findByMiembro_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM Asistir WHERE CLASE_id_clase = :idClase", nativeQuery = true)
    List<Asistir> findByClase_IdClase(@Param("idClase") Integer idClase);

    boolean existsByMiembro_CedulaAndClase_IdClase(String cedulaMiembro, Integer idClase);

    @Query(value = "SELECT COUNT(*) FROM Asistir WHERE CLASE_id_clase = :idClase", nativeQuery = true)
    long countByClase_IdClase(@Param("idClase") Integer idClase);
}