package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findByDuracion(String duracion);
}
