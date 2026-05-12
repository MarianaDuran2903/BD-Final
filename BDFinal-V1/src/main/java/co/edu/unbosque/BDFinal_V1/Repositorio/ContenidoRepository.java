package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Contenido;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    List<Contenido> findByDeporte_IdDeporte(Integer idDeporte);

    List<Contenido> findByTipoContenido(TipoContenido tipoContenido);

    List<Contenido> findByAutor(String autor);

    List<Contenido> findByFechaPublicacionBetween(LocalDate inicio, LocalDate fin);
}
