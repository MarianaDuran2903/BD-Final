package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Ejercicio;
import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.EjercicioRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanEntrenamientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EjercicioService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EjercicioServiceImpl implements EjercicioService {

    private final EjercicioRepository ejercicioRepository;
    private final PlanEntrenamientoRepository planRepository;
    private final ModelMapper mm = new ModelMapper();

    public EjercicioServiceImpl(EjercicioRepository ejercicioRepository,
                                PlanEntrenamientoRepository planRepository) {
        this.ejercicioRepository = ejercicioRepository;
        this.planRepository = planRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioResponseDTO> listarTodos() {
        return ejercicioRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EjercicioResponseDTO> buscarPorId(Integer id) {
        return ejercicioRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public EjercicioResponseDTO guardar(EjercicioRequestDTO dto) {
        PlanEntrenamiento plan = planRepository.findByAsignacion_IdAsignacion(dto.getIdAsignacion())
                .orElseThrow(() -> new RuntimeException(
                        "Plan de entrenamiento no encontrado para la asignación: " + dto.getIdAsignacion()));
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombreEjerc(dto.getNombreEjerc());
        ejercicio.setDescripcionEjerc(dto.getDescripcionEjerc());
        ejercicio.setRepsSerie(dto.getRepsSerie());
        ejercicio.setNumSeries(dto.getNumSeries());
        ejercicio.setPlanEntrenamiento(plan);
        return toResponseDTO(ejercicioRepository.save(ejercicio));
    }

    @Override
    public EjercicioResponseDTO actualizar(Integer id, EjercicioRequestDTO dto) {
        Ejercicio ejercicio = ejercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejercicio no encontrado con id: " + id));
        PlanEntrenamiento plan = planRepository.findByAsignacion_IdAsignacion(dto.getIdAsignacion())
                .orElseThrow(() -> new RuntimeException(
                        "Plan de entrenamiento no encontrado para la asignación: " + dto.getIdAsignacion()));
        ejercicio.setNombreEjerc(dto.getNombreEjerc());
        ejercicio.setDescripcionEjerc(dto.getDescripcionEjerc());
        ejercicio.setRepsSerie(dto.getRepsSerie());
        ejercicio.setNumSeries(dto.getNumSeries());
        ejercicio.setPlanEntrenamiento(plan);
        return toResponseDTO(ejercicioRepository.save(ejercicio));
    }

    @Override
    public void eliminar(Integer id) {
        if (!ejercicioRepository.existsById(id)) {
            throw new RuntimeException("Ejercicio no encontrado con id: " + id);
        }
        ejercicioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjercicioResponseDTO> buscarPorAsignacion(Integer idAsignacion) {
        return ejercicioRepository.findByPlanEntrenamiento_IdAsignacion(idAsignacion).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private EjercicioResponseDTO toResponseDTO(Ejercicio e) {
        EjercicioResponseDTO dto = mm.map(e, EjercicioResponseDTO.class);
        if (e.getPlanEntrenamiento() != null) {
            dto.setIdAsignacion(e.getPlanEntrenamiento().getIdAsignacion());
        }
        return dto;
    }
}
