package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Pago;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Integer> {

    @Query(value = "SELECT * FROM pago", nativeQuery = true)
    List<Pago> findAll();

    @Query(value = "SELECT * FROM pago WHERE id_pago = :id", nativeQuery = true)
    Optional<Pago> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Pago p WHERE p.idPago = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM pago WHERE MEMBRESIA_cedula = :cedula", nativeQuery = true)
    List<Pago> findByMembresia_Miembro_Cedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM pago WHERE fecha_pago BETWEEN :inicio AND :fin", nativeQuery = true)
    List<Pago> findByFechaPagoBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query(value = "SELECT * FROM pago WHERE metodo_pago = :metodo", nativeQuery = true)
    List<Pago> findByMetodoPago(@Param("metodo") String metodo);
}