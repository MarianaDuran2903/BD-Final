package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import java.util.List;
import java.util.Optional;

public interface PlanService {

    List<PlanResponseDTO> listarTodos();

    Optional<PlanResponseDTO> buscarPorId(Integer id);

    PlanResponseDTO guardar(PlanRequestDTO dto);

    PlanResponseDTO actualizar(Integer id, PlanRequestDTO dto);

    void eliminar(Integer id);

    List<PlanResponseDTO> buscarPorDuracion(DuracionPlan duracion);
}
