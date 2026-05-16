package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Asistir;
import co.edu.unbosque.BDFinal_V1.Modelo.AsistirId;
import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsistirResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.AsistirRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.ClaseRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.AsistirService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    public AsistirResponseDTO registrarAsistencia(AsistirRequestDTO dto) {
        if (asistirRepository.existsByMiembro_CedulaAndClase_IdClase(
                dto.getMiembroCedula(), dto.getClaseIdClase())) {
            throw new IllegalStateException("El miembro ya está inscrito en esta clase");
        }
        Miembro miembro = miembroRepository.findById(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getMiembroCedula()));
        Clase clase = claseRepository.findById(dto.getClaseIdClase())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada: " + dto.getClaseIdClase()));

        long inscritos = asistirRepository.countByClase_IdClase(dto.getClaseIdClase());
        if (inscritos >= clase.getCupos()) {
            throw new IllegalStateException("La clase no tiene cupos disponibles");
        }

        AsistirId id = new AsistirId(dto.getMiembroCedula(), dto.getClaseIdClase(),
                clase.getSala().getIdSala(), clase.getHorario().getIdHorario());
        return toResponseDTO(asistirRepository.save(new Asistir(id, miembro, clase)));
    }

    @Override
    public void cancelarAsistencia(AsistirRequestDTO dto) {
        Clase clase = claseRepository.findById(dto.getClaseIdClase())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada: " + dto.getClaseIdClase()));
        AsistirId id = new AsistirId(dto.getMiembroCedula(), dto.getClaseIdClase(),
                clase.getSala().getIdSala(), clase.getHorario().getIdHorario());
        if (!asistirRepository.existsById(id)) {
            throw new RuntimeException("Inscripción no encontrada");
        }
        asistirRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsistirResponseDTO> consultarPorMiembro(String cedula) {
        return asistirRepository.findByMiembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsistirResponseDTO> consultarPorClase(Integer idClase) {
        return asistirRepository.findByClase_IdClase(idClase).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
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

    private AsistirResponseDTO toResponseDTO(Asistir a) {
        AsistirResponseDTO dto = new AsistirResponseDTO();
        dto.setMiembroCedula(a.getId().getMiembroCedula());
        dto.setClaseIdClase(a.getId().getClaseIdClase());
        if (a.getMiembro() != null && a.getMiembro().getPersona() != null) {
            Persona mp = a.getMiembro().getPersona();
            dto.setNombreMiembro(mp.getPrimerNombre() + " " + mp.getPrimerApellido());
        }
        if (a.getClase() != null) {
            Clase clase = a.getClase();
            if (clase.getDeporte() != null) dto.setDeporteNombre(clase.getDeporte().getNombre());
            if (clase.getEntrenador() != null && clase.getEntrenador().getPersona() != null) {
                Persona ep = clase.getEntrenador().getPersona();
                dto.setNombreEntrenador(ep.getPrimerNombre() + " " + ep.getPrimerApellido());
            }
            dto.setFechaClase(clase.getFecha());
            if (clase.getSala() != null) dto.setIdSala(clase.getSala().getIdSala());
        }
        return dto;
    }
}
