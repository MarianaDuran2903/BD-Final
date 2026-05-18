package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    @Query(value = "SELECT * FROM clase", nativeQuery = true)
    List<Clase> findAll();

    @Query(value = "SELECT * FROM clase WHERE id_clase = :id", nativeQuery = true)
    Optional<Clase> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Clase c WHERE c.idClase = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM clase WHERE ENTRENADOR_cedula = :cedula", nativeQuery = true)
    List<Clase> findByEntrenador_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM clase WHERE DEPORTE_id_deporte = :idDeporte", nativeQuery = true)
    List<Clase> findByDeporte_IdDeporte(@Param("idDeporte") Integer idDeporte);

    @Query(value = "SELECT * FROM clase WHERE estado = :estado", nativeQuery = true)
    List<Clase> findByEstado(@Param("estado") EstadoClase estado);

    @Query(value = "SELECT * FROM clase WHERE Sala_id_sala = :idSala", nativeQuery = true)
    List<Clase> findBySala_IdSala(@Param("idSala") Integer idSala);

    @Query(value = "SELECT * FROM clase WHERE fecha = :fecha", nativeQuery = true)
    List<Clase> findByFecha(@Param("fecha") LocalDate fecha);

    @Query(value = "SELECT COUNT(*) FROM clase WHERE fecha = :fecha AND Sala_id_sala = :idSala AND Horario_id_horario = :idHorario", nativeQuery = true)
    Long countConflicto(@Param("fecha") LocalDate fecha, @Param("idSala") Integer idSala, @Param("idHorario") Integer idHorario);

    @Query(value = "SELECT COUNT(*) FROM clase WHERE fecha = :fecha AND Sala_id_sala = :idSala AND Horario_id_horario = :idHorario AND id_clase <> :excludeId", nativeQuery = true)
    Long countConflictoExcluyendo(@Param("fecha") LocalDate fecha, @Param("idSala") Integer idSala, @Param("idHorario") Integer idHorario, @Param("excludeId") Integer excludeId);

    @Modifying
    @Query(value = """
        UPDATE clase c
        JOIN horario h ON c.Horario_id_horario = h.id_horario
        SET c.estado = 'finalizada'
        WHERE c.estado = 'programada'
        AND (c.fecha < :hoy OR (c.fecha = :hoy AND h.hora_fin <= :ahora))
        """, nativeQuery = true)
    int finalizarClasesVencidas(@Param("hoy") LocalDate hoy, @Param("ahora") LocalTime ahora);
}