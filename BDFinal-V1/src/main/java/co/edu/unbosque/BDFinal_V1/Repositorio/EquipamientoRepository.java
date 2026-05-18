package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {

    @Query(value = "SELECT * FROM equipamiento", nativeQuery = true)
    List<Equipamiento> findAll();

    @Query(value = "SELECT * FROM equipamiento WHERE id_equipamiento = :id", nativeQuery = true)
    Optional<Equipamiento> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Equipamiento e WHERE e.idEquipamiento = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM equipamiento WHERE LOWER(nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))", nativeQuery = true)
    List<Equipamiento> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM equipamiento WHERE cantidad > :cantidad", nativeQuery = true)
    List<Equipamiento> findByCantidadGreaterThan(@Param("cantidad") Integer cantidad);
}