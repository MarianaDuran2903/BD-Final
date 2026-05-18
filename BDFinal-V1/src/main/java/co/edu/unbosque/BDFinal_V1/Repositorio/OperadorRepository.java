package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelTecnico;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface OperadorRepository extends JpaRepository<Operador, String> {

    @Query(value = "SELECT * FROM operador", nativeQuery = true)
    List<Operador> findAll();

    @Query(value = "SELECT * FROM operador WHERE cedula = :id", nativeQuery = true)
    Optional<Operador> findById(@Param("id") String id);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Operador o WHERE o.cedula = :id")
    boolean existsById(@Param("id") String id);

    @Query(value = "SELECT * FROM operador WHERE tipo_operador = :tipo", nativeQuery = true)
    List<Operador> findByTipoOperador(@Param("tipo") TipoOperador tipo);

    @Query(value = "SELECT * FROM operador WHERE especialidad = :especialidad", nativeQuery = true)
    List<Operador> findByEspecialidad(@Param("especialidad") EspecialidadOperador especialidad);

    @Query(value = "SELECT * FROM operador WHERE nivel_tecnico = :nivel", nativeQuery = true)
    List<Operador> findByNivelTecnico(@Param("nivel") NivelTecnico nivel);
}