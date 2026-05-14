package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query(value = "SELECT * FROM Horario", nativeQuery = true)
    List<Horario> findAll();

    @Query(value = "SELECT * FROM Horario WHERE id_horario = :id", nativeQuery = true)
    Optional<Horario> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM Horario h WHERE h.idHorario = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Horario WHERE fecha = :fecha", nativeQuery = true)
    List<Horario> findByFecha(@Param("fecha") LocalDate fecha);

    @Query(value = "SELECT * FROM Horario WHERE disponibilidad = :disponibilidad", nativeQuery = true)
    List<Horario> findByDisponibilidad(@Param("disponibilidad") DisponibilidadHorario disponibilidad);

    @Query(value = "SELECT * FROM Horario WHERE fecha BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Horario> findByFechaBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);
}