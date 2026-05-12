package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.Equipamiento;
import java.util.List;
import java.util.Optional;

public interface EquipamientoService {

    List<Equipamiento> listarTodos();

    Optional<Equipamiento> buscarPorId(Integer id);

    Equipamiento guardar(Equipamiento equipamiento);

    Equipamiento actualizar(Integer id, Equipamiento equipamiento);

    void eliminar(Integer id);

    List<Equipamiento> buscarPorNombre(String nombre);

    List<Equipamiento> buscarConStock();
}
