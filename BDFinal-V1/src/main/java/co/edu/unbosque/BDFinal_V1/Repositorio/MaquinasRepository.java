package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MaquinasRepository extends JpaRepository<Maquinas, Integer> {

    @Query(value = "SELECT * FROM MAQUINAS", nativeQuery = true)
    List<Maquinas> findAll();

    @Query(value = "SELECT * FROM MAQUINAS WHERE codigo_serie = :id", nativeQuery = true)
    Optional<Maquinas> findById(@Param("id") Integer id);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Maquinas m WHERE m.codigoSerie = :id")
    boolean existsById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM MAQUINAS WHERE tipo_maquina = :tipo", nativeQuery = true)
    List<Maquinas> findByTipoMaquina(@Param("tipo") TipoMaquina tipo);

    @Query(value = "SELECT * FROM MAQUINAS WHERE estado = :estado", nativeQuery = true)
    List<Maquinas> findByEstado(@Param("estado") EstadoMaquina estado);

    @Query(value = "SELECT * FROM MAQUINAS WHERE marca = :marca", nativeQuery = true)
    List<Maquinas> findByMarca(@Param("marca") String marca);
}