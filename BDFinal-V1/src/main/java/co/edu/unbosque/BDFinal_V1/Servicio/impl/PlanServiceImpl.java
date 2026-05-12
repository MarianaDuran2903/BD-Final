package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plan> listarTodos() {
        return planRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Plan> buscarPorId(Integer id) {
        return planRepository.findById(id);
    }

    @Override
    public Plan guardar(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan actualizar(Integer id, Plan plan) {
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Plan no encontrado con id: " + id);
        }
        plan.setIdPlan(id);
        return planRepository.save(plan);
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
    public List<Plan> buscarPorDuracion(DuracionPlan duracion) {
        return planRepository.findByDuracion(duracion);
    }
}
