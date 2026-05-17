package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoResponseDTO;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoService {

    Optional<PlanEntrenamientoResponseDTO> buscarPorAsignacion(Integer idAsignacion);

    List<PlanEntrenamientoResponseDTO> buscarPorMiembro(String cedula);

    List<PlanEntrenamientoResponseDTO> buscarPorEntrenador(String cedula);

    PlanEntrenamientoResponseDTO crear(PlanEntrenamientoRequestDTO dto);

    PlanEntrenamientoResponseDTO actualizar(Integer idAsignacion, PlanEntrenamientoRequestDTO dto);

    void eliminar(Integer idAsignacion);
}
