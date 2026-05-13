package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Deporte;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.DeporteResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.DeporteRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.DeporteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeporteServiceImpl implements DeporteService {

    private final DeporteRepository deporteRepository;
    private final ModelMapper mm = new ModelMapper();

    public DeporteServiceImpl(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeporteResponseDTO> listarTodos() {
        return deporteRepository.findAll().stream()
                .map(d -> mm.map(d, DeporteResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DeporteResponseDTO> buscarPorId(Integer id) {
        return deporteRepository.findById(id)
                .map(d -> mm.map(d, DeporteResponseDTO.class));
    }

    @Override
    public DeporteResponseDTO guardar(DeporteRequestDTO dto) {
        if (deporteRepository.existsByNombre(dto.getNombre())) {
            throw new IllegalArgumentException("Ya existe un deporte con el nombre: " + dto.getNombre());
        }
        Deporte deporte = mm.map(dto, Deporte.class);
        return mm.map(deporteRepository.save(deporte), DeporteResponseDTO.class);
    }

    @Override
    public DeporteResponseDTO actualizar(Integer id, DeporteRequestDTO dto) {
        if (!deporteRepository.existsById(id)) {
            throw new RuntimeException("Deporte no encontrado con id: " + id);
        }
        Deporte deporte = mm.map(dto, Deporte.class);
        deporte.setIdDeporte(id);
        return mm.map(deporteRepository.save(deporte), DeporteResponseDTO.class);
    }

    @Override
    public void eliminar(Integer id) {
        if (!deporteRepository.existsById(id)) {
            throw new RuntimeException("Deporte no encontrado con id: " + id);
        }
        deporteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DeporteResponseDTO> buscarPorNombre(String nombre) {
        return deporteRepository.findByNombre(nombre)
                .map(d -> mm.map(d, DeporteResponseDTO.class));
    }
}
