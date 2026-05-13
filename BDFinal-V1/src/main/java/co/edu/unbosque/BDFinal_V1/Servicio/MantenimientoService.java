package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MantenimientoService {

    List<MantenimientoResponseDTO> listarTodos();

    Optional<MantenimientoResponseDTO> buscarPorId(MantenimientoId id);

    MantenimientoResponseDTO registrar(MantenimientoRequestDTO dto);

    void eliminar(MantenimientoId id);

    List<MantenimientoResponseDTO> buscarPorOperador(String cedula);

    List<MantenimientoResponseDTO> buscarPorMaquina(Integer codigoSerie);

    List<MantenimientoResponseDTO> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<MantenimientoResponseDTO> buscarPorTipo(TipoMantenimiento tipo);
}
