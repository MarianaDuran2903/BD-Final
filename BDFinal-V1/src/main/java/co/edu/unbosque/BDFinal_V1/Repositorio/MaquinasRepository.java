package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaquinasRepository extends JpaRepository<Maquinas, Integer> {

    List<Maquinas> findByTipoMaquina(TipoMaquina tipoMaquina);

    List<Maquinas> findByEstado(EstadoMaquina estado);

    List<Maquinas> findByMarca(String marca);
}
