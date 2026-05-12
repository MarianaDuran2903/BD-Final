package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.RestriccionMedica;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import co.edu.unbosque.BDFinal_V1.Repositorio.RestriccionMedicaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.RestriccionMedicaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestriccionMedicaServiceImpl implements RestriccionMedicaService {

    private final RestriccionMedicaRepository restriccionMedicaRepository;

    public RestriccionMedicaServiceImpl(RestriccionMedicaRepository restriccionMedicaRepository) {
        this.restriccionMedicaRepository = restriccionMedicaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedica> listarTodas() {
        return restriccionMedicaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RestriccionMedica> buscarPorId(Integer id) {
        return restriccionMedicaRepository.findById(id);
    }

    @Override
    public RestriccionMedica guardar(RestriccionMedica restriccion) {
        return restriccionMedicaRepository.save(restriccion);
    }

    @Override
    public RestriccionMedica actualizar(Integer id, RestriccionMedica restriccion) {
        if (!restriccionMedicaRepository.existsById(id)) {
            throw new RuntimeException("Restricción médica no encontrada con id: " + id);
        }
        restriccion.setIdRestriccion(id);
        return restriccionMedicaRepository.save(restriccion);
    }

    @Override
    public void eliminar(Integer id) {
        if (!restriccionMedicaRepository.existsById(id)) {
            throw new RuntimeException("Restricción médica no encontrada con id: " + id);
        }
        restriccionMedicaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedica> buscarPorMiembro(String cedula) {
        return restriccionMedicaRepository.findByMiembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedica> buscarPorNivelGravedad(NivelGravedad nivel) {
        return restriccionMedicaRepository.findByNivelGravedad(nivel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedica> buscarPorTipo(TipoRestriccion tipo) {
        return restriccionMedicaRepository.findByTipo(tipo);
    }
}
