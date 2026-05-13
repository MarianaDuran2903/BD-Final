package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import java.util.List;
import java.util.Optional;

public interface MaquinasService {

    List<MaquinasResponseDTO> listarTodas();

    Optional<MaquinasResponseDTO> buscarPorId(Integer id);

    MaquinasResponseDTO guardar(MaquinasRequestDTO dto);

    MaquinasResponseDTO actualizar(Integer id, MaquinasRequestDTO dto);

    void eliminar(Integer id);

    List<MaquinasResponseDTO> buscarPorTipo(TipoMaquina tipo);

    List<MaquinasResponseDTO> buscarPorEstado(EstadoMaquina estado);

    MaquinasResponseDTO cambiarEstado(Integer id, EstadoMaquina nuevoEstado);
}
