package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import co.edu.unbosque.BDFinal_V1.Repositorio.ClaseRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.ClaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final EntrenadorRepository entrenadorRepository;

    public ClaseServiceImpl(ClaseRepository claseRepository, EntrenadorRepository entrenadorRepository) {
        this.claseRepository = claseRepository;
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> listarTodas() {
        return claseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clase> buscarPorId(Integer id) {
        return claseRepository.findById(id);
    }

    @Override
    public Clase guardar(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase actualizar(Integer id, Clase clase) {
        if (!claseRepository.existsById(id)) {
            throw new RuntimeException("Clase no encontrada con id: " + id);
        }
        clase.setIdClase(id);
        return claseRepository.save(clase);
    }

    @Override
    public void eliminar(Integer id) {
        if (!claseRepository.existsById(id)) {
            throw new RuntimeException("Clase no encontrada con id: " + id);
        }
        claseRepository.deleteById(id);
    }

    @Override
    public Clase asignarEntrenador(Integer idClase, String cedulaEntrenador) {
        Clase clase = claseRepository.findById(idClase)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada con id: " + idClase));
        Entrenador entrenador = entrenadorRepository.findById(cedulaEntrenador)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con cédula: " + cedulaEntrenador));
        clase.setEntrenador(entrenador);
        return claseRepository.save(clase);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entrenador> consultarEntrenadorDeClase(Integer idClase) {
        return claseRepository.findById(idClase).map(Clase::getEntrenador);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> buscarPorEntrenador(String cedula) {
        return claseRepository.findByEntrenador_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> buscarPorDeporte(Integer idDeporte) {
        return claseRepository.findByDeporte_IdDeporte(idDeporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> buscarPorEstado(EstadoClase estado) {
        return claseRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> buscarPorSala(Integer idSala) {
        return claseRepository.findBySala_IdSala(idSala);
    }
}
