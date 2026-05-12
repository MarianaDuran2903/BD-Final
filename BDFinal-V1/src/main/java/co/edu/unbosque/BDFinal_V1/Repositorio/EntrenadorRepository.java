package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, String> {

    List<Entrenador> findByTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento);

    List<Entrenador> findByNivelExigencia(NivelExigencia nivelExigencia);

    List<Entrenador> findByDeportes_IdDeporte(Integer idDeporte);

    boolean existsByCedula(String cedula);
}
