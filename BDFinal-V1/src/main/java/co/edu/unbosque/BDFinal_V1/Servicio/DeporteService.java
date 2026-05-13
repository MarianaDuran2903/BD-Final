package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import java.util.List;
import java.util.Optional;

public interface DeporteService {

    List<DeporteResponseDTO> listarTodos();

    Optional<DeporteResponseDTO> buscarPorId(Integer id);

    DeporteResponseDTO guardar(DeporteRequestDTO dto);

    DeporteResponseDTO actualizar(Integer id, DeporteRequestDTO dto);

    void eliminar(Integer id);

    Optional<DeporteResponseDTO> buscarPorNombre(String nombre);
}
