package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Horario;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import co.edu.unbosque.BDFinal_V1.Repositorio.HorarioRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.HorarioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;
    private final ModelMapper mm = new ModelMapper();

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorarioResponseDTO> listarTodos() {
        return horarioRepository.findAll().stream()
                .map(h -> mm.map(h, HorarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HorarioResponseDTO> buscarPorId(Integer id) {
        return horarioRepository.findById(id)
                .map(h -> mm.map(h, HorarioResponseDTO.class));
    }

    @Override
    public HorarioResponseDTO guardar(HorarioRequestDTO dto) {
        Horario horario = mm.map(dto, Horario.class);
        return mm.map(horarioRepository.save(horario), HorarioResponseDTO.class);
    }

    @Override
    public HorarioResponseDTO actualizar(Integer id, HorarioRequestDTO dto) {
        if (!horarioRepository.existsById(id)) {
            throw new RuntimeException("Horario no encontrado con id: " + id);
        }
        Horario horario = mm.map(dto, Horario.class);
        horario.setIdHorario(id);
        return mm.map(horarioRepository.save(horario), HorarioResponseDTO.class);
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
    public List<HorarioResponseDTO> buscarPorFecha(LocalDate fecha) {
        return horarioRepository.findByFecha(fecha).stream()
                .map(h -> mm.map(h, HorarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorarioResponseDTO> buscarDisponibles() {
        return horarioRepository.findByDisponibilidad(DisponibilidadHorario.disponible).stream()
                .map(h -> mm.map(h, HorarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorarioResponseDTO> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return horarioRepository.findByFechaBetween(inicio, fin).stream()
                .map(h -> mm.map(h, HorarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HorarioResponseDTO cambiarDisponibilidad(Integer id, DisponibilidadHorario disponibilidad) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado con id: " + id));
        horario.setDisponibilidad(disponibilidad);
        return mm.map(horarioRepository.save(horario), HorarioResponseDTO.class);
    }
}
