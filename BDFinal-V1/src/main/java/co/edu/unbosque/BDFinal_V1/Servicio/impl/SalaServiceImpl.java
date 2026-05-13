package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Sala;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.SalaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.SalaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.SalaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;
    private final ModelMapper mm = new ModelMapper();

    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalaResponseDTO> listarTodas() {
        return salaRepository.findAll().stream()
                .map(s -> mm.map(s, SalaResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SalaResponseDTO> buscarPorId(Integer id) {
        return salaRepository.findById(id)
                .map(s -> mm.map(s, SalaResponseDTO.class));
    }

    @Override
    public SalaResponseDTO guardar(SalaRequestDTO dto) {
        Sala sala = mm.map(dto, Sala.class);
        return mm.map(salaRepository.save(sala), SalaResponseDTO.class);
    }

    @Override
    public SalaResponseDTO actualizar(Integer id, SalaRequestDTO dto) {
        if (!salaRepository.existsById(id)) {
            throw new RuntimeException("Sala no encontrada con id: " + id);
        }
        Sala sala = mm.map(dto, Sala.class);
        sala.setIdSala(id);
        return mm.map(salaRepository.save(sala), SalaResponseDTO.class);
    }

    @Override
    public void eliminar(Integer id) {
        if (!salaRepository.existsById(id)) {
            throw new RuntimeException("Sala no encontrada con id: " + id);
        }
        salaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SalaResponseDTO> buscarPorCapacidadMinima(Short capacidad) {
        return salaRepository.findByCapacidadGreaterThanEqual(capacidad).stream()
                .map(s -> mm.map(s, SalaResponseDTO.class))
                .collect(Collectors.toList());
    }
}
