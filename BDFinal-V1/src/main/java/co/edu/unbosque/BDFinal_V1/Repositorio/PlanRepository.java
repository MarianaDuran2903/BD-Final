package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findByDuracion(DuracionPlan duracion);

    Optional<Plan> findFirstByDuracionOrderByPrecioAsc(DuracionPlan duracion);
}
