package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Equipamiento;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.EquipamientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Repositorio.EquipamientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.EquipamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipamientoServiceImpl implements EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;
    private final ModelMapper mm = new ModelMapper();

    public EquipamientoServiceImpl(EquipamientoRepository equipamientoRepository) {
        this.equipamientoRepository = equipamientoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipamientoResponseDTO> listarTodos() {
        return equipamientoRepository.findAll().stream()
                .map(e -> mm.map(e, EquipamientoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EquipamientoResponseDTO> buscarPorId(Integer id) {
        return equipamientoRepository.findById(id)
                .map(e -> mm.map(e, EquipamientoResponseDTO.class));
    }

    @Override
    public EquipamientoResponseDTO guardar(EquipamientoRequestDTO dto) {
        Equipamiento equipamiento = mm.map(dto, Equipamiento.class);
        return mm.map(equipamientoRepository.save(equipamiento), EquipamientoResponseDTO.class);
    }

    @Override
    public EquipamientoResponseDTO actualizar(Integer id, EquipamientoRequestDTO dto) {
        if (!equipamientoRepository.existsById(id)) {
            throw new RuntimeException("Equipamiento no encontrado con id: " + id);
        }
        Equipamiento equipamiento = mm.map(dto, Equipamiento.class);
        equipamiento.setIdEquipamiento(id);
        return mm.map(equipamientoRepository.save(equipamiento), EquipamientoResponseDTO.class);
    }

    @Override
    public void eliminar(Integer id) {
        if (!equipamientoRepository.existsById(id)) {
            throw new RuntimeException("Equipamiento no encontrado con id: " + id);
        }
        equipamientoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipamientoResponseDTO> buscarPorNombre(String nombre) {
        return equipamientoRepository.findByNombreContainingIgnoreCase(nombre).stream()
                .map(e -> mm.map(e, EquipamientoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipamientoResponseDTO> buscarConStock() {
        return equipamientoRepository.findByCantidadGreaterThan(0).stream()
                .map(e -> mm.map(e, EquipamientoResponseDTO.class))
                .collect(Collectors.toList());
    }
}
