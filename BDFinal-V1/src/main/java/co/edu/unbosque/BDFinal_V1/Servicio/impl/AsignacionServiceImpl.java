package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Asignacion;
import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.AsignacionResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.AsignacionRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.AsignacionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AsignacionServiceImpl implements AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final MiembroRepository miembroRepository;

    public AsignacionServiceImpl(AsignacionRepository asignacionRepository,
                                 EntrenadorRepository entrenadorRepository,
                                 MiembroRepository miembroRepository) {
        this.asignacionRepository = asignacionRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.miembroRepository = miembroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignacionResponseDTO> listarTodas() {
        return asignacionRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignacionResponseDTO> buscarPorId(Integer id) {
        return asignacionRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignacionResponseDTO> listarPorEntrenador(String cedula) {
        return asignacionRepository.findByEntrenador_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignacionResponseDTO> listarPorMiembro(String cedula) {
        return asignacionRepository.findByMiembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignacionResponseDTO crear(AsignacionRequestDTO dto) {
        if (asignacionRepository.existsByEntrenador_CedulaAndMiembro_Cedula(
                dto.getCedulaEntrenador(), dto.getCedulaMiembro())) {
            throw new IllegalStateException("Ya existe una asignación entre ese entrenador y ese miembro.");
        }
        Entrenador entrenador = entrenadorRepository.findById(dto.getCedulaEntrenador())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + dto.getCedulaEntrenador()));
        Miembro miembro = miembroRepository.findById(dto.getCedulaMiembro())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getCedulaMiembro()));

        Asignacion a = new Asignacion();
        a.setEntrenador(entrenador);
        a.setMiembro(miembro);
        a.setFechaAsignacion(dto.getFechaAsignacion());
        return toResponseDTO(asignacionRepository.save(a));
    }

    @Override
    public void eliminar(Integer id) {
        if (!asignacionRepository.existsById(id)) {
            throw new RuntimeException("Asignación no encontrada con id: " + id);
        }
        asignacionRepository.deleteById(id);
    }

    private AsignacionResponseDTO toResponseDTO(Asignacion a) {
        AsignacionResponseDTO dto = new AsignacionResponseDTO();
        dto.setIdAsignacion(a.getIdAsignacion());
        dto.setFechaAsignacion(a.getFechaAsignacion());
        dto.setTienePlan(a.getPlanEntrenamiento() != null);

        if (a.getEntrenador() != null) {
            dto.setCedulaEntrenador(a.getEntrenador().getCedula());
            Persona ep = a.getEntrenador().getPersona();
            if (ep != null) dto.setNombreEntrenador(ep.getPrimerNombre() + " " + ep.getPrimerApellido());
        }
        if (a.getMiembro() != null) {
            dto.setCedulaMiembro(a.getMiembro().getCedula());
            Persona mp = a.getMiembro().getPersona();
            if (mp != null) dto.setNombreMiembro(mp.getPrimerNombre() + " " + mp.getPrimerApellido());
        }
        return dto;
    }
}
