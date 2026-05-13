package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.MiembroRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MiembroResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MiembroService {

    List<MiembroResponseDTO> listarTodos();

    Optional<MiembroResponseDTO> buscarPorCedula(String cedula);

    MiembroResponseDTO guardar(MiembroRequestDTO dto);

    MiembroResponseDTO actualizar(String cedula, MiembroRequestDTO dto);

    void eliminar(String cedula);

    List<MiembroResponseDTO> buscarPorNivelExperiencia(NivelExperiencia nivel);

    List<MiembroResponseDTO> buscarPorRangoAltura(Short min, Short max);

    List<MiembroResponseDTO> buscarPorRangoPeso(BigDecimal min, BigDecimal max);

    boolean existeMiembro(String cedula);
}
