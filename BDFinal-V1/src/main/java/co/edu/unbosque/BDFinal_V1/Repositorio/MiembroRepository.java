package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface MiembroRepository extends JpaRepository<Miembro, String> {

    List<Miembro> findByNivelExperiencia(NivelExperiencia nivelExperiencia);

    List<Miembro> findByAlturaBetween(Short min, Short max);

    List<Miembro> findByPesoActualBetween(BigDecimal min, BigDecimal max);

    Optional<Miembro> findByPersona_Correo(String correo);

    boolean existsByCedula(String cedula);
}
