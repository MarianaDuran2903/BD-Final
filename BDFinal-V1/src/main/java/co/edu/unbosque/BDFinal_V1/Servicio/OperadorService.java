package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.OperadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import java.util.List;
import java.util.Optional;

public interface OperadorService {

    List<OperadorResponseDTO> listarTodos();

    Optional<OperadorResponseDTO> buscarPorCedula(String cedula);

    OperadorResponseDTO guardar(OperadorRequestDTO dto);

    OperadorResponseDTO actualizar(String cedula, OperadorRequestDTO dto);

    void eliminar(String cedula);

    List<OperadorResponseDTO> buscarPorTipoOperador(TipoOperador tipo);

    List<OperadorResponseDTO> buscarPorEspecialidad(EspecialidadOperador especialidad);
}
