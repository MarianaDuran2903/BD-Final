package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.PlanEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanEntrenamientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PlanEntrenamientoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlanEntrenamientoServiceImpl implements PlanEntrenamientoService {

    private final PlanEntrenamientoRepository planEntrenamientoRepository;

    public PlanEntrenamientoServiceImpl(PlanEntrenamientoRepository planEntrenamientoRepository) {
        this.planEntrenamientoRepository = planEntrenamientoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanEntrenamiento> buscarPorMiembro(String cedula) {
        return planEntrenamientoRepository.findByMiembro_Cedula(cedula);
    }

    @Override
    public PlanEntrenamiento asignarRutina(PlanEntrenamiento plan) {
        if (planEntrenamientoRepository.existsByMiembro_Cedula(plan.getMiembroCedula())) {
            throw new IllegalStateException("El miembro ya tiene un plan de entrenamiento asignado. Use actualizar.");
        }
        return planEntrenamientoRepository.save(plan);
    }

    @Override
    public PlanEntrenamiento actualizarRutina(String cedula, PlanEntrenamiento plan) {
        if (!planEntrenamientoRepository.existsByMiembro_Cedula(cedula)) {
            throw new RuntimeException("No se encontró plan de entrenamiento para el miembro: " + cedula);
        }
        plan.setMiembroCedula(cedula);
        return planEntrenamientoRepository.save(plan);
    }

    @Override
    public void eliminarRutina(String cedula) {
        PlanEntrenamiento plan = planEntrenamientoRepository.findByMiembro_Cedula(cedula)
                .orElseThrow(() -> new RuntimeException("No se encontró plan de entrenamiento para el miembro: " + cedula));
        planEntrenamientoRepository.delete(plan);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean tienePlanAsignado(String cedula) {
        return planEntrenamientoRepository.existsByMiembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanEntrenamiento> buscarPorEntrenador(String cedula) {
        return planEntrenamientoRepository.findByEntrenador_Cedula(cedula);
    }
}
