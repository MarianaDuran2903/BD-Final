package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import java.util.List;
import java.util.Optional;

public interface EntrenadorService {

    List<Entrenador> listarTodos();

    Optional<Entrenador> buscarPorCedula(String cedula);

    Entrenador guardar(Entrenador entrenador);

    Entrenador actualizar(String cedula, Entrenador entrenador);

    void eliminar(String cedula);

    List<Entrenador> buscarPorTipoEntrenamiento(TipoEntrenamiento tipo);

    List<Entrenador> buscarPorNivelExigencia(NivelExigencia nivel);

    List<Entrenador> buscarPorDeporte(Integer idDeporte);

    boolean existeEntrenador(String cedula);
}
