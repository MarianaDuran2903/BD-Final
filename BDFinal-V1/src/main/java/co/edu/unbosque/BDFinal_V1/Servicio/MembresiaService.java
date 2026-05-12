package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import java.util.List;
import java.util.Optional;

public interface MembresiaService {

    List<Membresia> listarTodas();

    Optional<Membresia> buscarPorId(MembresiaId id);

    Membresia guardar(Membresia membresia);

    Membresia actualizar(MembresiaId id, Membresia membresia);

    void eliminar(MembresiaId id);

    List<Membresia> buscarPorMiembro(String cedula);

    List<Membresia> buscarPorEstado(EstadoMembresia estado);

    List<Membresia> buscarActivasPorMiembro(String cedula);

    Optional<Membresia> buscarMembresiaVigente(String cedula);
}
