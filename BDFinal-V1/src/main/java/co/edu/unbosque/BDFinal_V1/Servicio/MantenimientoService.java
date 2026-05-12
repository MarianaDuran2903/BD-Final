package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Mantenimiento;
import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MantenimientoService {

    List<Mantenimiento> listarTodos();

    Optional<Mantenimiento> buscarPorId(MantenimientoId id);

    Mantenimiento registrar(Mantenimiento mantenimiento);

    void eliminar(MantenimientoId id);

    List<Mantenimiento> buscarPorOperador(String cedula);

    List<Mantenimiento> buscarPorMaquina(Integer codigoSerie);

    List<Mantenimiento> buscarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<Mantenimiento> buscarPorTipo(TipoMantenimiento tipo);
}
