package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Ejercicio;
import co.edu.unbosque.BDFinal_V1.Repositorio.EjercicioRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EjercicioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EjercicioServiceImpl implements EjercicioService {

    private final EjercicioRepository ejercicioRepository;

    public EjercicioServiceImpl(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ejercicio> listarTodos() {
        return ejercicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ejercicio> buscarPorId(Integer id) {
        return ejercicioRepository.findById(id);
    }

    @Override
    public Ejercicio guardar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public Ejercicio actualizar(Integer id, Ejercicio ejercicio) {
        if (!ejercicioRepository.existsById(id)) {
            throw new RuntimeException("Ejercicio no encontrado con id: " + id);
        }
        ejercicio.setIdEjercicio(id);
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public void eliminar(Integer id) {
        if (!ejercicioRepository.existsById(id)) {
            throw new RuntimeException("Ejercicio no encontrado con id: " + id);
        }
        ejercicioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ejercicio> buscarPorPlanDeMiembro(String cedula) {
        return ejercicioRepository.findByPlanEntrenamiento_MiembroCedula(cedula);
    }
}
