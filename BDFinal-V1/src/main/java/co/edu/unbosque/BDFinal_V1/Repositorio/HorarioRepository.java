package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    List<Horario> findByFecha(LocalDate fecha);

    List<Horario> findByDisponibilidad(DisponibilidadHorario disponibilidad);

    List<Horario> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
