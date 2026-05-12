package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.RestriccionMedica;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import java.util.List;
import java.util.Optional;

public interface RestriccionMedicaService {

    List<RestriccionMedica> listarTodas();

    Optional<RestriccionMedica> buscarPorId(Integer id);

    RestriccionMedica guardar(RestriccionMedica restriccion);

    RestriccionMedica actualizar(Integer id, RestriccionMedica restriccion);

    void eliminar(Integer id);

    List<RestriccionMedica> buscarPorMiembro(String cedula);

    List<RestriccionMedica> buscarPorNivelGravedad(NivelGravedad nivel);

    List<RestriccionMedica> buscarPorTipo(TipoRestriccion tipo);
}
