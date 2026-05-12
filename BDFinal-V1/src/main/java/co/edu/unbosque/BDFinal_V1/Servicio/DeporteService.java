package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import java.util.List;
import java.util.Optional;

public interface DeporteService {

    List<Deporte> listarTodos();

    Optional<Deporte> buscarPorId(Integer id);

    Deporte guardar(Deporte deporte);

    Deporte actualizar(Integer id, Deporte deporte);

    void eliminar(Integer id);

    Optional<Deporte> buscarPorNombre(String nombre);
}
