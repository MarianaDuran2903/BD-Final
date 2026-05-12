package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Contenido;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import java.util.List;
import java.util.Optional;

public interface ContenidoService {

    List<Contenido> listarTodos();

    Optional<Contenido> buscarPorId(Integer id);

    Contenido guardar(Contenido contenido);

    Contenido actualizar(Integer id, Contenido contenido);

    void eliminar(Integer id);

    List<Contenido> buscarPorDeporte(Integer idDeporte);

    List<Contenido> buscarPorTipo(TipoContenido tipo);
}
