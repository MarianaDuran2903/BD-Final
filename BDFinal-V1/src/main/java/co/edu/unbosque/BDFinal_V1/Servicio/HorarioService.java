package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HorarioService {

    List<Horario> listarTodos();

    Optional<Horario> buscarPorId(Integer id);

    Horario guardar(Horario horario);

    Horario actualizar(Integer id, Horario horario);

    void eliminar(Integer id);

    List<Horario> buscarPorFecha(LocalDate fecha);

    List<Horario> buscarDisponibles();

    List<Horario> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);

    Horario cambiarDisponibilidad(Integer id, DisponibilidadHorario disponibilidad);
}
