package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Contenido;
import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.ContenidoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import co.edu.unbosque.BDFinal_V1.Repositorio.ContenidoRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.DeporteRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.ContenidoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContenidoServiceImpl implements ContenidoService {

    private final ContenidoRepository contenidoRepository;
    private final DeporteRepository deporteRepository;
    private final ModelMapper mm = new ModelMapper();

    public ContenidoServiceImpl(ContenidoRepository contenidoRepository,
                                DeporteRepository deporteRepository) {
        this.contenidoRepository = contenidoRepository;
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContenidoResponseDTO> listarTodos() {
        return contenidoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ContenidoResponseDTO> buscarPorId(Integer id) {
        return contenidoRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public ContenidoResponseDTO guardar(ContenidoRequestDTO dto) {
        Deporte deporte = deporteRepository.findById(dto.getIdDeporte())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado con id: " + dto.getIdDeporte()));
        Contenido contenido = mm.map(dto, Contenido.class);
        contenido.setDeporte(deporte);
        return toResponseDTO(contenidoRepository.save(contenido));
    }

    @Override
    public ContenidoResponseDTO actualizar(Integer id, ContenidoRequestDTO dto) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado con id: " + id);
        }
        Deporte deporte = deporteRepository.findById(dto.getIdDeporte())
                .orElseThrow(() -> new RuntimeException("Deporte no encontrado con id: " + dto.getIdDeporte()));
        Contenido contenido = mm.map(dto, Contenido.class);
        contenido.setIdContenido(id);
        contenido.setDeporte(deporte);
        return toResponseDTO(contenidoRepository.save(contenido));
    }

    @Override
    public void eliminar(Integer id) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado con id: " + id);
        }
        contenidoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContenidoResponseDTO> buscarPorDeporte(Integer idDeporte) {
        return contenidoRepository.findByDeporte_IdDeporte(idDeporte).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContenidoResponseDTO> buscarPorTipo(TipoContenido tipo) {
        return contenidoRepository.findByTipoContenido(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private ContenidoResponseDTO toResponseDTO(Contenido contenido) {
        ContenidoResponseDTO dto = mm.map(contenido, ContenidoResponseDTO.class);
        if (contenido.getDeporte() != null) {
            dto.setDeporte(mm.map(contenido.getDeporte(), DeporteResponseDTO.class));
        }
        return dto;
    }
}
