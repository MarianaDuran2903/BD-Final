package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoResponseDTO;
import java.util.List;
import java.util.Optional;

public interface EquipamientoService {

    List<EquipamientoResponseDTO> listarTodos();

    Optional<EquipamientoResponseDTO> buscarPorId(Integer id);

    EquipamientoResponseDTO guardar(EquipamientoRequestDTO dto);

    EquipamientoResponseDTO actualizar(Integer id, EquipamientoRequestDTO dto);

    void eliminar(Integer id);

    List<EquipamientoResponseDTO> buscarPorNombre(String nombre);

    List<EquipamientoResponseDTO> buscarConStock();
}
