package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<PagoResponseDTO> listarTodos();

    Optional<PagoResponseDTO> buscarPorId(Integer id);

    PagoResponseDTO registrar(PagoRequestDTO dto);

    void eliminar(Integer id);

    List<PagoResponseDTO> historialPorMiembro(String cedula);

    List<PagoResponseDTO> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<PagoResponseDTO> buscarPorMetodoPago(MetodoPago metodo);
}
