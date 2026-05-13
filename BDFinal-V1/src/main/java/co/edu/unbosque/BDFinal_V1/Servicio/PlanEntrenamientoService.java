package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanEntrenamientoResponseDTO;
import java.util.List;
import java.util.Optional;

public interface PlanEntrenamientoService {

    Optional<PlanEntrenamientoResponseDTO> buscarPorMiembro(String cedula);

    PlanEntrenamientoResponseDTO asignarRutina(PlanEntrenamientoRequestDTO dto);

    PlanEntrenamientoResponseDTO actualizarRutina(String cedula, PlanEntrenamientoRequestDTO dto);

    void eliminarRutina(String cedula);

    boolean tienePlanAsignado(String cedula);

    List<PlanEntrenamientoResponseDTO> buscarPorEntrenador(String cedula);
}
