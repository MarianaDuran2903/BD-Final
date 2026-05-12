package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Pago;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> listarTodos();

    Optional<Pago> buscarPorId(Integer id);

    Pago registrar(Pago pago);

    void eliminar(Integer id);

    List<Pago> historialPorMiembro(String cedula);

    List<Pago> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<Pago> buscarPorMetodoPago(MetodoPago metodo);
}
