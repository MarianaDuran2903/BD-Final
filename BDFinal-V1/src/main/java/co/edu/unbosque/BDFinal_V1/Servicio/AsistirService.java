package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirResponseDTO;
import java.util.List;

public interface AsistirService {

    AsistirResponseDTO registrarAsistencia(AsistirRequestDTO dto);

    void cancelarAsistencia(AsistirRequestDTO dto);

    List<AsistirResponseDTO> consultarPorMiembro(String cedula);

    List<AsistirResponseDTO> consultarPorClase(Integer idClase);

    boolean yaEstaInscrito(String cedulaMiembro, Integer idClase);

    long contarAsistenciasPorClase(Integer idClase);
}
