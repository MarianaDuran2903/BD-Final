package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelTecnico;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OperadorRepository extends JpaRepository<Operador, String> {

    List<Operador> findByTipoOperador(TipoOperador tipoOperador);

    List<Operador> findByEspecialidad(EspecialidadOperador especialidad);

    List<Operador> findByNivelTecnico(NivelTecnico nivelTecnico);
}
