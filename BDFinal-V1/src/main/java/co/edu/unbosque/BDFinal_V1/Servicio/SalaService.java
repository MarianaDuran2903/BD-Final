package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Sala;
import java.util.List;
import java.util.Optional;

public interface SalaService {

    List<Sala> listarTodas();

    Optional<Sala> buscarPorId(Integer id);

    Sala guardar(Sala sala);

    Sala actualizar(Integer id, Sala sala);

    void eliminar(Integer id);

    List<Sala> buscarPorCapacidadMinima(Short capacidad);
}
