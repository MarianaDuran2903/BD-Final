package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    // Req. 10: historial de pagos de un miembro
    List<Pago> findByMembresiaMiembroCedula(String cedula);

    // Pagos por rango de fechas
    List<Pago> findByFechaPagoBetween(LocalDate inicio, LocalDate fin);

    // Pagos por método
    List<Pago> findByMetodoPago(String metodoPago);
}
