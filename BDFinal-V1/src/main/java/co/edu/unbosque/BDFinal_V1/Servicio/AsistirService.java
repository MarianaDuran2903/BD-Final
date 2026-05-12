package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Asistir;
import co.edu.unbosque.BDFinal_V1.Modelo.AsistirId;
import java.util.List;

public interface AsistirService {

    Asistir registrarAsistencia(AsistirId id);

    void cancelarAsistencia(AsistirId id);

    List<Asistir> consultarPorMiembro(String cedula);

    List<Asistir> consultarPorClase(Integer idClase);

    boolean yaEstaInscrito(String cedulaMiembro, Integer idClase);

    long contarAsistenciasPorClase(Integer idClase);
}
