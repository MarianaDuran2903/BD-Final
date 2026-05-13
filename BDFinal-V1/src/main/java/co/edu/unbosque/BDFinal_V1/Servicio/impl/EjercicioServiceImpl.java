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
    private final PlanEntrenamientoRepository planEntrenamientoRepository;
    private final ModelMapper mm = new ModelMapper();

    public EjercicioServiceImpl(EjercicioRepository ejercicioRepository,
                                PlanEntrenamientoRepository planEntrenamientoRepository) {
        this.ejercicioRepository = ejercicioRepository;
        this.planEntrenamientoRepository = planEntrenamientoRepository;
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
        PlanEntrenamiento plan = planEntrenamientoRepository.findByMiembro_Cedula(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException(
                        "Plan de entrenamiento no encontrado para el miembro: " + dto.getMiembroCedula()));
        Ejercicio ejercicio = mm.map(dto, Ejercicio.class);
        ejercicio.setPlanEntrenamiento(plan);
        return toResponseDTO(ejercicioRepository.save(ejercicio));
    }

    @Override
    public EjercicioResponseDTO actualizar(Integer id, EjercicioRequestDTO dto) {
        if (!ejercicioRepository.existsById(id)) {
            throw new RuntimeException("Ejercicio no encontrado con id: " + id);
        }
        PlanEntrenamiento plan = planEntrenamientoRepository.findByMiembro_Cedula(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException(
                        "Plan de entrenamiento no encontrado para el miembro: " + dto.getMiembroCedula()));
        Ejercicio ejercicio = mm.map(dto, Ejercicio.class);
        ejercicio.setIdEjercicio(id);
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
    public List<EjercicioResponseDTO> buscarPorPlanDeMiembro(String cedula) {
        return ejercicioRepository.findByPlanEntrenamiento_MiembroCedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private EjercicioResponseDTO toResponseDTO(Ejercicio e) {
        EjercicioResponseDTO dto = mm.map(e, EjercicioResponseDTO.class);
        if (e.getPlanEntrenamiento() != null) {
            dto.setMiembroCedula(e.getPlanEntrenamiento().getMiembroCedula());
        }
        return dto;
    }
}
