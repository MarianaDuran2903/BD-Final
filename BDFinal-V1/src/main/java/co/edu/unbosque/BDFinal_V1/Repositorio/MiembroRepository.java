package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MiembroRepository extends JpaRepository<Miembro, String> {

    @Query(value = "SELECT * FROM MIEMBRO", nativeQuery = true)
    List<Miembro> findAll();

    @Query(value = "SELECT * FROM MIEMBRO WHERE cedula = :id", nativeQuery = true)
    Optional<Miembro> findById(@Param("id") String id);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Miembro m WHERE m.cedula = :id")
    boolean existsById(@Param("id") String id);

    @Query(value = "SELECT * FROM MIEMBRO WHERE nivel_experiencia = :nivel", nativeQuery = true)
    List<Miembro> findByNivelExperiencia(@Param("nivel") NivelExperiencia nivel);

    @Query(value = "SELECT * FROM MIEMBRO WHERE altura BETWEEN :min AND :max", nativeQuery = true)
    List<Miembro> findByAlturaBetween(@Param("min") Short min, @Param("max") Short max);

    @Query(value = "SELECT * FROM MIEMBRO WHERE peso_actual BETWEEN :min AND :max", nativeQuery = true)
    List<Miembro> findByPesoActualBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query(value = "SELECT m.* FROM MIEMBRO m JOIN PERSONA p ON m.cedula = p.cedula WHERE p.correo = :correo", nativeQuery = true)
    Optional<Miembro> findByPersona_Correo(@Param("correo") String correo);

    boolean existsByCedula(String cedula);

    @Modifying
    @Query(value = "DELETE FROM MIEMBRO WHERE cedula = :cedula", nativeQuery = true)
    void deleteByCedula(@Param("cedula") String cedula);
}