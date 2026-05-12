package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Sala;
import co.edu.unbosque.BDFinal_V1.Repositorio.SalaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.SalaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sala> buscarPorId(Integer id) {
        return salaRepository.findById(id);
    }

    @Override
    public Sala guardar(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala actualizar(Integer id, Sala sala) {
        if (!salaRepository.existsById(id)) {
            throw new RuntimeException("Sala no encontrada con id: " + id);
        }
        sala.setIdSala(id);
        return salaRepository.save(sala);
    }

    @Override
    public void eliminar(Integer id) {
        if (!salaRepository.existsById(id)) {
            throw new RuntimeException("Sala no encontrada con id: " + id);
        }
        salaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sala> buscarPorCapacidadMinima(Short capacidad) {
        return salaRepository.findByCapacidadGreaterThanEqual(capacidad);
    }
}
