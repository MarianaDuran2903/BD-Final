package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Clase;
import co.edu.unbosque.BDFinal_V1.Modelo.Entrenador;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ClaseResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.HorarioResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import co.edu.unbosque.BDFinal_V1.Repositorio.ClaseRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.DeporteRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.EntrenadorRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.HorarioRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.SalaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.ClaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final SalaRepository salaRepository;
    private final HorarioRepository horarioRepository;
    private final DeporteRepository deporteRepository;
    private final ModelMapper mm = new ModelMapper();

    public ClaseServiceImpl(ClaseRepository claseRepository,
                            EntrenadorRepository entrenadorRepository,
                            SalaRepository salaRepository,
                            HorarioRepository horarioRepository,
                            DeporteRepository deporteRepository) {
        this.claseRepository = claseRepository;
        this.entrenadorRepository = entrenadorRepository;
        this.salaRepository = salaRepository;
        this.horarioRepository = horarioRepository;
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseResponseDTO> listarTodas() {
        return claseRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClaseResponseDTO> buscarPorId(Integer id) {
        return claseRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public ClaseResponseDTO guardar(ClaseRequestDTO dto) {
        Clase clase = new Clase();
        clase.setEstado(dto.getEstado());
        clase.setComentario(dto.getComentario());
        clase.setCupos(dto.getCupos());
        clase.setSala(salaRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala no encontrada: " + dto.getIdSala())));
        clase.setHorario(horarioRepository.findById(dto.getIdHorario())
                .orElseThrow(() -> new RuntimeException("Horario no encontrado: " + dto.getIdHorario())));
        clase.setDeporte(deporteRepository.findById(dto.getIdDeporte())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado: " + dto.getIdDeporte())));
        clase.setEntrenador(entrenadorRepository.findById(dto.getCedulaEntrenador())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + dto.getCedulaEntrenador())));
        return toResponseDTO(claseRepository.save(clase));
    }

    @Override
    public ClaseResponseDTO actualizar(Integer id, ClaseRequestDTO dto) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada con id: " + id));
        clase.setEstado(dto.getEstado());
        clase.setComentario(dto.getComentario());
        clase.setCupos(dto.getCupos());
        clase.setSala(salaRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala no encontrada: " + dto.getIdSala())));
        clase.setHorario(horarioRepository.findById(dto.getIdHorario())
                .orElseThrow(() -> new RuntimeException("Horario no encontrado: " + dto.getIdHorario())));
        clase.setDeporte(deporteRepository.findById(dto.getIdDeporte())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado: " + dto.getIdDeporte())));
        clase.setEntrenador(entrenadorRepository.findById(dto.getCedulaEntrenador())
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + dto.getCedulaEntrenador())));
        return toResponseDTO(claseRepository.save(clase));
    }

    @Override
    public void eliminar(Integer id) {
        if (!claseRepository.existsById(id)) {
            throw new RuntimeException("Clase no encontrada con id: " + id);
        }
        claseRepository.deleteById(id);
    }

    @Override
    public ClaseResponseDTO asignarEntrenador(Integer idClase, String cedulaEntrenador) {
        Clase clase = claseRepository.findById(idClase)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada con id: " + idClase));
        Entrenador entrenador = entrenadorRepository.findById(cedulaEntrenador)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado con cédula: " + cedulaEntrenador));
        clase.setEntrenador(entrenador);
        return toResponseDTO(claseRepository.save(clase));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseResponseDTO> buscarPorEntrenador(String cedula) {
        return claseRepository.findByEntrenador_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseResponseDTO> buscarPorDeporte(Integer idDeporte) {
        return claseRepository.findByDeporte_IdDeporte(idDeporte).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseResponseDTO> buscarPorEstado(EstadoClase estado) {
        return claseRepository.findByEstado(estado).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaseResponseDTO> buscarPorSala(Integer idSala) {
        return claseRepository.findBySala_IdSala(idSala).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private ClaseResponseDTO toResponseDTO(Clase c) {
        ClaseResponseDTO dto = new ClaseResponseDTO();
        dto.setIdClase(c.getIdClase());
        dto.setEstado(c.getEstado());
        dto.setComentario(c.getComentario());
        dto.setCupos(c.getCupos());
        if (c.getSala() != null) dto.setSala(mm.map(c.getSala(), SalaResponseDTO.class));
        if (c.getHorario() != null) dto.setHorario(mm.map(c.getHorario(), HorarioResponseDTO.class));
        if (c.getDeporte() != null) dto.setDeporte(mm.map(c.getDeporte(), DeporteResponseDTO.class));
        if (c.getEntrenador() != null) {
            dto.setCedulaEntrenador(c.getEntrenador().getCedula());
            if (c.getEntrenador().getPersona() != null) {
                Persona p = c.getEntrenador().getPersona();
                dto.setNombreEntrenador(p.getPrimerNombre() + " " + p.getPrimerApellido());
            }
        }
        return dto;
    }
}
