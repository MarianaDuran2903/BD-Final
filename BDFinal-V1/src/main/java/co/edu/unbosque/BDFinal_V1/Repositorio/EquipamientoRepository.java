package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {

    List<Equipamiento> findByNombreContainingIgnoreCase(String nombre);

    List<Equipamiento> findByCantidadGreaterThan(Integer cantidad);
}
