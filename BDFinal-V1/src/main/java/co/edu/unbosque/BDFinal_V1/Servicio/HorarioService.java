package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.DiaSemana;
import java.util.List;
import java.util.Optional;

public interface HorarioService {

    List<HorarioResponseDTO> listarTodos();

    Optional<HorarioResponseDTO> buscarPorId(Integer id);

    HorarioResponseDTO guardar(HorarioRequestDTO dto);

    HorarioResponseDTO actualizar(Integer id, HorarioRequestDTO dto);

    void eliminar(Integer id);

    List<HorarioResponseDTO> buscarPorDia(DiaSemana dia);
}