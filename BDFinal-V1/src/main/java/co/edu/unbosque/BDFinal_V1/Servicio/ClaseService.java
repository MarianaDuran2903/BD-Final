package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import java.util.List;
import java.util.Optional;

public interface ClaseService {

    List<Clase> listarTodas();

    Optional<Clase> buscarPorId(Integer id);

    Clase guardar(Clase clase);

    Clase actualizar(Integer id, Clase clase);

    void eliminar(Integer id);

    Clase asignarEntrenador(Integer idClase, String cedulaEntrenador);

    Optional<Entrenador> consultarEntrenadorDeClase(Integer idClase);

    List<Clase> buscarPorEntrenador(String cedula);

    List<Clase> buscarPorDeporte(Integer idDeporte);

    List<Clase> buscarPorEstado(EstadoClase estado);

    List<Clase> buscarPorSala(Integer idSala);
}
