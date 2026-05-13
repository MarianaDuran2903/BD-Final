package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EjercicioResponseDTO;
import java.util.List;
import java.util.Optional;

public interface EjercicioService {

    List<EjercicioResponseDTO> listarTodos();

    Optional<EjercicioResponseDTO> buscarPorId(Integer id);

    EjercicioResponseDTO guardar(EjercicioRequestDTO dto);

    EjercicioResponseDTO actualizar(Integer id, EjercicioRequestDTO dto);

    void eliminar(Integer id);

    List<EjercicioResponseDTO> buscarPorPlanDeMiembro(String cedula);
}
