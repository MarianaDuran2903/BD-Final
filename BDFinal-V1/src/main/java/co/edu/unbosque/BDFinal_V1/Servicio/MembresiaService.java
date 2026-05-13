package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import java.util.List;
import java.util.Optional;

public interface MembresiaService {

    List<MembresiaResponseDTO> listarTodas();

    Optional<MembresiaResponseDTO> buscarPorId(MembresiaId id);

    MembresiaResponseDTO guardar(MembresiaRequestDTO dto);

    MembresiaResponseDTO actualizar(MembresiaId id, MembresiaRequestDTO dto);

    void eliminar(MembresiaId id);

    List<MembresiaResponseDTO> buscarPorMiembro(String cedula);

    List<MembresiaResponseDTO> buscarPorEstado(EstadoMembresia estado);

    List<MembresiaResponseDTO> buscarActivasPorMiembro(String cedula);

    Optional<MembresiaResponseDTO> buscarMembresiaVigente(String cedula);
}
