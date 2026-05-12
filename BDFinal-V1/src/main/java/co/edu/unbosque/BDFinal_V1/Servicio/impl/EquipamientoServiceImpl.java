package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Equipamiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.EquipamientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EquipamientoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipamientoServiceImpl implements EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;

    public EquipamientoServiceImpl(EquipamientoRepository equipamientoRepository) {
        this.equipamientoRepository = equipamientoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipamiento> listarTodos() {
        return equipamientoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipamiento> buscarPorId(Integer id) {
        return equipamientoRepository.findById(id);
    }

    @Override
    public Equipamiento guardar(Equipamiento equipamiento) {
        return equipamientoRepository.save(equipamiento);
    }

    @Override
    public Equipamiento actualizar(Integer id, Equipamiento equipamiento) {
        if (!equipamientoRepository.existsById(id)) {
            throw new RuntimeException("Equipamiento no encontrado con id: " + id);
        }
        equipamiento.setIdEquipamiento(id);
        return equipamientoRepository.save(equipamiento);
    }

    @Override
    public void eliminar(Integer id) {
        if (!equipamientoRepository.existsById(id)) {
            throw new RuntimeException("Equipamiento no encontrado con id: " + id);
        }
        equipamientoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipamiento> buscarPorNombre(String nombre) {
        return equipamientoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipamiento> buscarConStock() {
        return equipamientoRepository.findByCantidadGreaterThan(0);
    }
}
