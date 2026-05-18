package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MembresiaRepository extends JpaRepository<Membresia, MembresiaId> {

    @Query(value = "SELECT * FROM membresia", nativeQuery = true)
    List<Membresia> findAll();

    @Query("SELECT m FROM Membresia m WHERE m.id = :id")
    Optional<Membresia> findById(@Param("id") MembresiaId id);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Membresia m WHERE m.id = :id")
    boolean existsById(@Param("id") MembresiaId id);

    @Query("SELECT m FROM Membresia m WHERE m.estado = :estado")
    List<Membresia> findByEstado(@Param("estado") EstadoMembresia estado);

    @Query(value = "SELECT * FROM membresia WHERE MIEMBRO_cedula = :cedula", nativeQuery = true)
    List<Membresia> findByMiembro_Cedula(@Param("cedula") String cedula);

    @Query("SELECT m FROM Membresia m WHERE m.id.miembroCedula = :cedula AND m.estado = :estado")
    List<Membresia> findByMiembro_CedulaAndEstado(@Param("cedula") String cedula, @Param("estado") EstadoMembresia estado);
}