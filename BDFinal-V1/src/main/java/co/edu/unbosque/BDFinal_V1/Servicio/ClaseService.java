package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import java.util.List;
import java.util.Optional;

public interface ClaseService {

    List<ClaseResponseDTO> listarTodas();

    Optional<ClaseResponseDTO> buscarPorId(Integer id);

    ClaseResponseDTO guardar(ClaseRequestDTO dto);

    ClaseResponseDTO actualizar(Integer id, ClaseRequestDTO dto);

    void eliminar(Integer id);

    ClaseResponseDTO asignarEntrenador(Integer idClase, String cedulaEntrenador);

    List<ClaseResponseDTO> buscarPorEntrenador(String cedula);

    List<ClaseResponseDTO> buscarPorDeporte(Integer idDeporte);

    List<ClaseResponseDTO> buscarPorEstado(EstadoClase estado);

    List<ClaseResponseDTO> buscarPorSala(Integer idSala);
}
