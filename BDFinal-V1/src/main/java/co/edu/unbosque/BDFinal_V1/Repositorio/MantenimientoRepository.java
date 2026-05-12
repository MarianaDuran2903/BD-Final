package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Mantenimiento;
import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, MantenimientoId> {

    List<Mantenimiento> findByOperador_Cedula(String cedula);

    List<Mantenimiento> findByMaquina_CodigoSerie(Integer codigoSerie);

    List<Mantenimiento> findByFechaMantenimientoBetween(LocalDate inicio, LocalDate fin);

    List<Mantenimiento> findByTipoMant(TipoMantenimiento tipoMant);
}
