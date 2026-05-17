package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Asignacion;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.AsignacionRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanEntrenamientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanEntrenamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanEntrenamientoServiceImpl implements PlanEntrenamientoService {

    private final PlanEntrenamientoRepository planRepo;
    private final AsignacionRepository asignacionRepository;
    private final ModelMapper mm = new ModelMapper();

    public PlanEntrenamientoServiceImpl(PlanEntrenamientoRepository planRepo,
                                        AsignacionRepository asignacionRepository) {
        this.planRepo = planRepo;
        this.asignacionRepository = asignacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanEntrenamientoResponseDTO> buscarPorAsignacion(Integer idAsignacion) {
        return planRepo.findByAsignacion_IdAsignacion(idAsignacion).map(this::toResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanEntrenamientoResponseDTO> buscarPorMiembro(String cedula) {
        return planRepo.findByAsignacion_Miembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanEntrenamientoResponseDTO> buscarPorEntrenador(String cedula) {
        return planRepo.findByAsignacion_Entrenador_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlanEntrenamientoResponseDTO crear(PlanEntrenamientoRequestDTO dto) {
        Asignacion asignacion = asignacionRepository.findById(dto.getIdAsignacion())
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada: " + dto.getIdAsignacion()));
        if (planRepo.existsByAsignacion_IdAsignacion(dto.getIdAsignacion())) {
            throw new IllegalStateException("Esta asignación ya tiene un plan de entrenamiento. Use actualizar.");
        }
        PlanEntrenamiento plan = new PlanEntrenamiento();
        plan.setAsignacion(asignacion);
        plan.setDescripcion(dto.getDescripcion());
        return toResponseDTO(planRepo.save(plan));
    }

    @Override
    public PlanEntrenamientoResponseDTO actualizar(Integer idAsignacion, PlanEntrenamientoRequestDTO dto) {
        PlanEntrenamiento plan = planRepo.findByAsignacion_IdAsignacion(idAsignacion)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado para la asignación: " + idAsignacion));
        plan.setDescripcion(dto.getDescripcion());
        return toResponseDTO(planRepo.save(plan));
    }

    @Override
    public void eliminar(Integer idAsignacion) {
        PlanEntrenamiento plan = planRepo.findByAsignacion_IdAsignacion(idAsignacion)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado para la asignación: " + idAsignacion));
        planRepo.delete(plan);
    }

    private PlanEntrenamientoResponseDTO toResponseDTO(PlanEntrenamiento pe) {
        PlanEntrenamientoResponseDTO dto = new PlanEntrenamientoResponseDTO();
        dto.setIdAsignacion(pe.getIdAsignacion());
        dto.setDescripcion(pe.getDescripcion());

        Asignacion a = pe.getAsignacion();
        if (a != null) {
            if (a.getMiembro() != null) {
                dto.setCedulaMiembro(a.getMiembro().getCedula());
                Persona mp = a.getMiembro().getPersona();
                if (mp != null) dto.setNombreMiembro(mp.getPrimerNombre() + " " + mp.getPrimerApellido());
            }
            if (a.getEntrenador() != null) {
                dto.setCedulaEntrenador(a.getEntrenador().getCedula());
                Persona ep = a.getEntrenador().getPersona();
                if (ep != null) dto.setNombreEntrenador(ep.getPrimerNombre() + " " + ep.getPrimerApellido());
            }
        }
        if (pe.getEjercicios() != null) {
            dto.setEjercicios(pe.getEjercicios().stream()
                    .map(e -> {
                        EjercicioResponseDTO edto = mm.map(e, EjercicioResponseDTO.class);
                        edto.setIdAsignacion(pe.getIdAsignacion());
                        return edto;
                    })
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
