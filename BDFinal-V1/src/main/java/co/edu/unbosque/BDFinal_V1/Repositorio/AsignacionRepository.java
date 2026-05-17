package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {

    List<Asignacion> findByEntrenador_Cedula(String cedula);

    List<Asignacion> findByMiembro_Cedula(String cedula);

    boolean existsByEntrenador_CedulaAndMiembro_Cedula(String cedulaEntrenador, String cedulaMiembro);
}
