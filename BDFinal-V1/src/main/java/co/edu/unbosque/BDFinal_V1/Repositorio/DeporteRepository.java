package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DeporteRepository extends JpaRepository<Deporte, Integer> {

    Optional<Deporte> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
