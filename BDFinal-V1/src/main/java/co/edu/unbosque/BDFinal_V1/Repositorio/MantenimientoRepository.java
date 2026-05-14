package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Mantenimiento;
import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, MantenimientoId> {

    @Query(value = "SELECT * FROM Mantenimiento", nativeQuery = true)
    List<Mantenimiento> findAll();

    @Query("SELECT m FROM Mantenimiento m WHERE m.id = :id")
    Optional<Mantenimiento> findById(@Param("id") MantenimientoId id);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Mantenimiento m WHERE m.id = :id")
    boolean existsById(@Param("id") MantenimientoId id);

    @Query(value = "SELECT * FROM Mantenimiento WHERE OPERADOR_cedula = :cedula", nativeQuery = true)
    List<Mantenimiento> findByOperador_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM Mantenimiento WHERE MAQUINAS_codigo_serie = :codigoSerie", nativeQuery = true)
    List<Mantenimiento> findByMaquina_CodigoSerie(@Param("codigoSerie") Integer codigoSerie);

    @Query(value = "SELECT * FROM Mantenimiento WHERE fecha_mantenimiento BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Mantenimiento> findByFechaMantenimientoBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query(value = "SELECT * FROM Mantenimiento WHERE tipo_mant = :tipo", nativeQuery = true)
    List<Mantenimiento> findByTipoMant(@Param("tipo") TipoMantenimiento tipo);
}