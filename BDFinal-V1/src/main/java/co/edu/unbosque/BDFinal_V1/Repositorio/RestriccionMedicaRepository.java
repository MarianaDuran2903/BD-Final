package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.RestriccionMedica;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestriccionMedicaRepository extends JpaRepository<RestriccionMedica, Integer> {

    List<RestriccionMedica> findByMiembro_Cedula(String cedula);

    List<RestriccionMedica> findByNivelGravedad(NivelGravedad nivelGravedad);

    List<RestriccionMedica> findByTipo(TipoRestriccion tipo);
}
