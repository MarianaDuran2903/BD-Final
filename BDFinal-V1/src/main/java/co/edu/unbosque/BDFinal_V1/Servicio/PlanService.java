package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import java.util.List;
import java.util.Optional;

public interface PlanService {

    List<Plan> listarTodos();

    Optional<Plan> buscarPorId(Integer id);

    Plan guardar(Plan plan);

    Plan actualizar(Integer id, Plan plan);

    void eliminar(Integer id);

    List<Plan> buscarPorDuracion(DuracionPlan duracion);
}
