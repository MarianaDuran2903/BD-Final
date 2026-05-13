package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import java.util.List;
import java.util.Optional;

public interface ContenidoService {

    List<ContenidoResponseDTO> listarTodos();

    Optional<ContenidoResponseDTO> buscarPorId(Integer id);

    ContenidoResponseDTO guardar(ContenidoRequestDTO dto);

    ContenidoResponseDTO actualizar(Integer id, ContenidoRequestDTO dto);

    void eliminar(Integer id);

    List<ContenidoResponseDTO> buscarPorDeporte(Integer idDeporte);

    List<ContenidoResponseDTO> buscarPorTipo(TipoContenido tipo);
}
