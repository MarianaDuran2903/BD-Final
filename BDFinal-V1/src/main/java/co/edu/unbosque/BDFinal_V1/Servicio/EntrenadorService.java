package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EntrenadorResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import java.util.List;
import java.util.Optional;

public interface EntrenadorService {

    List<EntrenadorResponseDTO> listarTodos();

    Optional<EntrenadorResponseDTO> buscarPorCedula(String cedula);

    EntrenadorResponseDTO guardar(EntrenadorRequestDTO dto);

    EntrenadorResponseDTO actualizar(String cedula, EntrenadorRequestDTO dto);

    void eliminar(String cedula);

    List<EntrenadorResponseDTO> buscarPorTipoEntrenamiento(TipoEntrenamiento tipo);

    List<EntrenadorResponseDTO> buscarPorNivelExigencia(NivelExigencia nivel);

    List<EntrenadorResponseDTO> buscarPorDeporte(Integer idDeporte);

    boolean existeEntrenador(String cedula);
}
