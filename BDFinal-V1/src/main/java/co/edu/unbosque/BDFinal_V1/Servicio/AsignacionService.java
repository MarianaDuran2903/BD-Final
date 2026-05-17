package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionResponseDTO;
import java.util.List;
import java.util.Optional;

public interface AsignacionService {

    List<AsignacionResponseDTO> listarTodas();

    Optional<AsignacionResponseDTO> buscarPorId(Integer id);

    List<AsignacionResponseDTO> listarPorEntrenador(String cedula);

    List<AsignacionResponseDTO> listarPorMiembro(String cedula);

    AsignacionResponseDTO crear(AsignacionRequestDTO dto);

    void eliminar(Integer id);
}
