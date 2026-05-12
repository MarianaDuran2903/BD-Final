package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Pago;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    List<Pago> findByMembresia_Miembro_Cedula(String cedula);

    List<Pago> findByFechaPagoBetween(LocalDate inicio, LocalDate fin);

    List<Pago> findByMetodoPago(MetodoPago metodoPago);
}
