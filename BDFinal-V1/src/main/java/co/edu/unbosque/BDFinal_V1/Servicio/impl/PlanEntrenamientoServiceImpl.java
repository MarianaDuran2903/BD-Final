package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.Ejercicio;
import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
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

    private final PlanEntrenamientoRepository planEntrenamientoRepository;
    private final MiembroRepository miembroRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final ModelMapper mm = new ModelMapper();

    public PlanEntrenamientoServiceImpl(PlanEntrenamientoRepository planEntrenamientoRepository,
                                        MiembroRepository miembroRepository,
                                        EntrenadorRepository entrenadorRepository) {
        this.planEntrenamientoRepository = planEntrenamientoRepository;
        this.miembroRepository = miembroRepository;
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanEntrenamientoResponseDTO> buscarPorMiembro(String cedula) {
        return planEntrenamientoRepository.findByMiembro_Cedula(cedula).map(this::toResponseDTO);
    }

    @Override
    public PlanEntrenamientoResponseDTO asignarRutina(PlanEntrenamientoRequestDTO dto) {
        if (planEntrenamientoRepository.existsByMiembro_Cedula(dto.getMiembroCedula())) {
            throw new IllegalStateException("El miembro ya tiene un plan de entrenamiento. Use actualizar.");
        }
        Miembro miembro = miembroRepository.findById(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getMiembroCedula()));
        Entrenador entrenador = entrenadorRepository.findById(dto.getCedulaEntrenador())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + dto.getCedulaEntrenador()));

        PlanEntrenamiento plan = new PlanEntrenamiento();
        plan.setMiembroCedula(miembro.getCedula());
        plan.setMiembro(miembro);
        plan.setEntrenador(entrenador);
        plan.setDescripcion(dto.getDescripcion());
        return toResponseDTO(planEntrenamientoRepository.save(plan));
    }

    @Override
    public PlanEntrenamientoResponseDTO actualizarRutina(String cedula, PlanEntrenamientoRequestDTO dto) {
        PlanEntrenamiento plan = planEntrenamientoRepository.findByMiembro_Cedula(cedula)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado para el miembro: " + cedula));
        Entrenador entrenador = entrenadorRepository.findById(dto.getCedulaEntrenador())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + dto.getCedulaEntrenador()));
        plan.setEntrenador(entrenador);
        plan.setDescripcion(dto.getDescripcion());
        return toResponseDTO(planEntrenamientoRepository.save(plan));
    }

    @Override
    public void eliminarRutina(String cedula) {
        PlanEntrenamiento plan = planEntrenamientoRepository.findByMiembro_Cedula(cedula)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado para el miembro: " + cedula));
        planEntrenamientoRepository.delete(plan);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean tienePlanAsignado(String cedula) {
        return planEntrenamientoRepository.existsByMiembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanEntrenamientoResponseDTO> buscarPorEntrenador(String cedula) {
        return planEntrenamientoRepository.findByEntrenador_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private PlanEntrenamientoResponseDTO toResponseDTO(PlanEntrenamiento pe) {
        PlanEntrenamientoResponseDTO dto = new PlanEntrenamientoResponseDTO();
        dto.setMiembroCedula(pe.getMiembroCedula());
        dto.setDescripcion(pe.getDescripcion());
        if (pe.getMiembro() != null && pe.getMiembro().getPersona() != null) {
            Persona mp = pe.getMiembro().getPersona();
            dto.setNombreMiembro(mp.getPrimerNombre() + " " + mp.getPrimerApellido());
        }
        if (pe.getEntrenador() != null) {
            dto.setCedulaEntrenador(pe.getEntrenador().getCedula());
            if (pe.getEntrenador().getPersona() != null) {
                Persona ep = pe.getEntrenador().getPersona();
                dto.setNombreEntrenador(ep.getPrimerNombre() + " " + ep.getPrimerApellido());
            }
        }
        if (pe.getEjercicios() != null) {
            dto.setEjercicios(pe.getEjercicios().stream()
                    .map(e -> {
                        EjercicioResponseDTO edto = mm.map(e, EjercicioResponseDTO.class);
                        edto.setMiembroCedula(pe.getMiembroCedula());
                        return edto;
                    })
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
