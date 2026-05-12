package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EntrenadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorServiceImpl(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> listarTodos() {
        return entrenadorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entrenador> buscarPorCedula(String cedula) {
        return entrenadorRepository.findById(cedula);
    }

    @Override
    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public Entrenador actualizar(String cedula, Entrenador entrenador) {
        if (!entrenadorRepository.existsById(cedula)) {
            throw new RuntimeException("Entrenador no encontrado con cédula: " + cedula);
        }
        entrenador.setCedula(cedula);
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public void eliminar(String cedula) {
        if (!entrenadorRepository.existsById(cedula)) {
            throw new RuntimeException("Entrenador no encontrado con cédula: " + cedula);
        }
        entrenadorRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> buscarPorTipoEntrenamiento(TipoEntrenamiento tipo) {
        return entrenadorRepository.findByTipoEntrenamiento(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> buscarPorNivelExigencia(NivelExigencia nivel) {
        return entrenadorRepository.findByNivelExigencia(nivel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entrenador> buscarPorDeporte(Integer idDeporte) {
        return entrenadorRepository.findByDeportes_IdDeporte(idDeporte);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeEntrenador(String cedula) {
        return entrenadorRepository.existsById(cedula);
    }
}
