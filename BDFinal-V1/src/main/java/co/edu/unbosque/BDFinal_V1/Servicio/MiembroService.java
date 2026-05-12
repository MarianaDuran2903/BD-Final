package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MiembroService {

    List<Miembro> listarTodos();

    Optional<Miembro> buscarPorCedula(String cedula);

    Miembro guardar(Miembro miembro);

    Miembro actualizar(String cedula, Miembro miembro);

    void eliminar(String cedula);

    List<Miembro> buscarPorNivelExperiencia(NivelExperiencia nivel);

    List<Miembro> buscarPorRangoAltura(Short min, Short max);

    List<Miembro> buscarPorRangoPeso(BigDecimal min, BigDecimal max);

    boolean existeMiembro(String cedula);
}
