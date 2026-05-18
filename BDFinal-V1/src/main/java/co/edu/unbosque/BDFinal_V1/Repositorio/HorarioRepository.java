package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query(value = "SELECT * FROM horario", nativeQuery = true)
    List<Horario> findAll();

    @Query(value = "SELECT * FROM horario WHERE id_horario = :id", nativeQuery = true)
    Optional<Horario> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM Horario h WHERE h.idHorario = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM horario WHERE dia_semana = :dia", nativeQuery = true)
    List<Horario> findByDiaSemana(@Param("dia") String dia);
}