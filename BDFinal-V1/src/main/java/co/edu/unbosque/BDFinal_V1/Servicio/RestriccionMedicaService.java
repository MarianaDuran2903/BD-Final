package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import java.util.List;
import java.util.Optional;

public interface RestriccionMedicaService {

    List<RestriccionMedicaResponseDTO> listarTodas();

    Optional<RestriccionMedicaResponseDTO> buscarPorId(Integer id);

    RestriccionMedicaResponseDTO guardar(RestriccionMedicaRequestDTO dto);

    RestriccionMedicaResponseDTO actualizar(Integer id, RestriccionMedicaRequestDTO dto);

    void eliminar(Integer id);

    List<RestriccionMedicaResponseDTO> buscarPorMiembro(String cedula);

    List<RestriccionMedicaResponseDTO> buscarPorNivelGravedad(NivelGravedad nivel);

    List<RestriccionMedicaResponseDTO> buscarPorTipo(TipoRestriccion tipo);
}
