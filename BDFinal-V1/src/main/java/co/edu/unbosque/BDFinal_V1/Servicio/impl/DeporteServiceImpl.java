package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import co.edu.unbosque.BDFinal_V1.Repositorio.DeporteRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.DeporteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeporteServiceImpl implements DeporteService {

    private final DeporteRepository deporteRepository;

    public DeporteServiceImpl(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Deporte> listarTodos() {
        return deporteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Deporte> buscarPorId(Integer id) {
        return deporteRepository.findById(id);
    }

    @Override
    public Deporte guardar(Deporte deporte) {
        if (deporteRepository.existsByNombre(deporte.getNombre())) {
            throw new IllegalArgumentException("Ya existe un deporte con el nombre: " + deporte.getNombre());
        }
        return deporteRepository.save(deporte);
    }

    @Override
    public Deporte actualizar(Integer id, Deporte deporte) {
        if (!deporteRepository.existsById(id)) {
            throw new RuntimeException("Deporte no encontrado con id: " + id);
        }
        deporte.setIdDeporte(id);
        return deporteRepository.save(deporte);
    }

    @Override
    public void eliminar(Integer id) {
        if (!deporteRepository.existsById(id)) {
            throw new RuntimeException("Deporte no encontrado con id: " + id);
        }
        deporteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Deporte> buscarPorNombre(String nombre) {
        return deporteRepository.findByNombre(nombre);
    }
}
