package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;
    private final ModelMapper mm = new ModelMapper();

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanResponseDTO> listarTodos() {
        return planRepository.findAll().stream()
                .map(p -> mm.map(p, PlanResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanResponseDTO> buscarPorId(Integer id) {
        return planRepository.findById(id)
                .map(p -> mm.map(p, PlanResponseDTO.class));
    }

    @Override
    public PlanResponseDTO guardar(PlanRequestDTO dto) {
        Plan plan = mm.map(dto, Plan.class);
        return mm.map(planRepository.save(plan), PlanResponseDTO.class);
    }

    @Override
    public PlanResponseDTO actualizar(Integer id, PlanRequestDTO dto) {
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Plan no encontrado con id: " + id);
        }
        Plan plan = mm.map(dto, Plan.class);
        plan.setIdPlan(id);
        return mm.map(planRepository.save(plan), PlanResponseDTO.class);
    }

    @Override
    public void eliminar(Integer id) {
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Plan no encontrado con id: " + id);
        }
        planRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanResponseDTO> buscarPorDuracion(DuracionPlan duracion) {
        return planRepository.findByDuracion(duracion).stream()
                .map(p -> mm.map(p, PlanResponseDTO.class))
                .collect(Collectors.toList());
    }
}
