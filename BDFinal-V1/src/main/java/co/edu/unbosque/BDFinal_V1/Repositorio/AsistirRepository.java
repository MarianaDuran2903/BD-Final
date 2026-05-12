package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Asistir;
import co.edu.unbosque.BDFinal_V1.Modelo.AsistirId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsistirRepository extends JpaRepository<Asistir, AsistirId> {

    List<Asistir> findByMiembro_Cedula(String cedula);

    List<Asistir> findByClase_IdClase(Integer idClase);

    boolean existsByMiembro_CedulaAndClase_IdClase(String cedulaMiembro, Integer idClase);

    long countByClase_IdClase(Integer idClase);
}
