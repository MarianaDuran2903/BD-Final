package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    List<Clase> findByEntrenador_Cedula(String cedula);

    List<Clase> findByDeporte_IdDeporte(Integer idDeporte);

    List<Clase> findByEstado(EstadoClase estado);

    List<Clase> findBySala_IdSala(Integer idSala);
}
