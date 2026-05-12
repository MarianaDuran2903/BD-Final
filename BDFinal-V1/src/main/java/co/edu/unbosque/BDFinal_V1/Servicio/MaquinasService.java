package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import java.util.List;
import java.util.Optional;

public interface MaquinasService {

    List<Maquinas> listarTodas();

    Optional<Maquinas> buscarPorId(Integer id);

    Maquinas guardar(Maquinas maquina);

    Maquinas actualizar(Integer id, Maquinas maquina);

    void eliminar(Integer id);

    List<Maquinas> buscarPorTipo(TipoMaquina tipo);

    List<Maquinas> buscarPorEstado(EstadoMaquina estado);

    Maquinas cambiarEstado(Integer id, EstadoMaquina nuevoEstado);
}
