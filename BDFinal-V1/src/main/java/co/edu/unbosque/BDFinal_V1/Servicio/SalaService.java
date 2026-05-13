package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaResponseDTO;
import java.util.List;
import java.util.Optional;

public interface SalaService {

    List<SalaResponseDTO> listarTodas();

    Optional<SalaResponseDTO> buscarPorId(Integer id);

    SalaResponseDTO guardar(SalaRequestDTO dto);

    SalaResponseDTO actualizar(Integer id, SalaRequestDTO dto);

    void eliminar(Integer id);

    List<SalaResponseDTO> buscarPorCapacidadMinima(Short capacidad);
}
