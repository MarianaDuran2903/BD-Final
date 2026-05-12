package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembresiaRepository extends JpaRepository<Membresia, MembresiaId> {

    List<Membresia> findByEstado(EstadoMembresia estado);

    List<Membresia> findByMiembro_Cedula(String cedula);

    List<Membresia> findByMiembro_CedulaAndEstado(String cedula, EstadoMembresia estado);
}
