package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import java.util.List;
import java.util.Optional;

public interface OperadorService {

    List<Operador> listarTodos();

    Optional<Operador> buscarPorCedula(String cedula);

    Operador guardar(Operador operador);

    Operador actualizar(String cedula, Operador operador);

    void eliminar(String cedula);

    List<Operador> buscarPorTipoOperador(TipoOperador tipo);

    List<Operador> buscarPorEspecialidad(EspecialidadOperador especialidad);
}
