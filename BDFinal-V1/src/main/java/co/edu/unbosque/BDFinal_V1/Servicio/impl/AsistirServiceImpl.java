package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Asistir;
import co.edu.unbosque.BDFinal_V1.Modelo.AsistirId;
import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Repositorio.AsistirRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.ClaseRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.AsistirService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AsistirServiceImpl implements AsistirService {

    private final AsistirRepository asistirRepository;
    private final MiembroRepository miembroRepository;
    private final ClaseRepository claseRepository;

    public AsistirServiceImpl(AsistirRepository asistirRepository,
                              MiembroRepository miembroRepository,
                              ClaseRepository claseRepository) {
        this.asistirRepository = asistirRepository;
        this.miembroRepository = miembroRepository;
        this.claseRepository = claseRepository;
    }

    @Override
    public Asistir registrarAsistencia(AsistirId id) {
        if (asistirRepository.existsByMiembro_CedulaAndClase_IdClase(
                id.getMiembroCedula(), id.getClaseIdClase())) {
            throw new IllegalStateException("El miembro ya está inscrito en esta clase");
        }
        Miembro miembro = miembroRepository.findById(id.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + id.getMiembroCedula()));
        Clase clase = claseRepository.findById(id.getClaseIdClase())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada: " + id.getClaseIdClase()));

        long inscritos = asistirRepository.countByClase_IdClase(id.getClaseIdClase());
        if (inscritos >= clase.getCupos()) {
            throw new IllegalStateException("La clase no tiene cupos disponibles");
        }

        return asistirRepository.save(new Asistir(id, miembro, clase));
    }

    @Override
    public void cancelarAsistencia(AsistirId id) {
        if (!asistirRepository.existsById(id)) {
            throw new RuntimeException("Inscripción no encontrada");
        }
        asistirRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asistir> consultarPorMiembro(String cedula) {
        return asistirRepository.findByMiembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asistir> consultarPorClase(Integer idClase) {
        return asistirRepository.findByClase_IdClase(idClase);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean yaEstaInscrito(String cedulaMiembro, Integer idClase) {
        return asistirRepository.existsByMiembro_CedulaAndClase_IdClase(cedulaMiembro, idClase);
    }

    @Override
    @Transactional(readOnly = true)
    public long contarAsistenciasPorClase(Integer idClase) {
        return asistirRepository.countByClase_IdClase(idClase);
    }
}
