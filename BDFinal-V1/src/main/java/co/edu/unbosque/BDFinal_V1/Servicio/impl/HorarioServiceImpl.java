package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import co.edu.unbosque.BDFinal_V1.Repositorio.HorarioRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.HorarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> listarTodos() {
        return horarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Horario> buscarPorId(Integer id) {
        return horarioRepository.findById(id);
    }

    @Override
    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public Horario actualizar(Integer id, Horario horario) {
        if (!horarioRepository.existsById(id)) {
            throw new RuntimeException("Horario no encontrado con id: " + id);
        }
        horario.setIdHorario(id);
        return horarioRepository.save(horario);
    }

    @Override
    public void eliminar(Integer id) {
        if (!horarioRepository.existsById(id)) {
            throw new RuntimeException("Horario no encontrado con id: " + id);
        }
        horarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> buscarPorFecha(LocalDate fecha) {
        return horarioRepository.findByFecha(fecha);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> buscarDisponibles() {
        return horarioRepository.findByDisponibilidad(DisponibilidadHorario.disponible);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Horario> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return horarioRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    public Horario cambiarDisponibilidad(Integer id, DisponibilidadHorario disponibilidad) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        horario.setDisponibilidad(disponibilidad);
        return horarioRepository.save(horario);
    }
}
