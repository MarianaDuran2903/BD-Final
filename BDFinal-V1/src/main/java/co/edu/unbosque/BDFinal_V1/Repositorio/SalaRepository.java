package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

    List<Sala> findByCapacidadGreaterThanEqual(Short capacidad);
}
