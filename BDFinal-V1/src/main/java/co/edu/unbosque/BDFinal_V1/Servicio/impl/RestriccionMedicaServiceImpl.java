package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.RestriccionMedica;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.RestriccionMedicaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.RestriccionMedicaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.RestriccionMedicaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestriccionMedicaServiceImpl implements RestriccionMedicaService {

    private final RestriccionMedicaRepository restriccionMedicaRepository;
    private final MiembroRepository miembroRepository;
    private final ModelMapper mm = new ModelMapper();

    public RestriccionMedicaServiceImpl(RestriccionMedicaRepository restriccionMedicaRepository,
                                        MiembroRepository miembroRepository) {
        this.restriccionMedicaRepository = restriccionMedicaRepository;
        this.miembroRepository = miembroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedicaResponseDTO> listarTodas() {
        return restriccionMedicaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RestriccionMedicaResponseDTO> buscarPorId(Integer id) {
        return restriccionMedicaRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public RestriccionMedicaResponseDTO guardar(RestriccionMedicaRequestDTO dto) {
        Miembro miembro = miembroRepository.findById(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getMiembroCedula()));
        RestriccionMedica restriccion = mm.map(dto, RestriccionMedica.class);
        restriccion.setMiembro(miembro);
        return toResponseDTO(restriccionMedicaRepository.save(restriccion));
    }

    @Override
    public RestriccionMedicaResponseDTO actualizar(Integer id, RestriccionMedicaRequestDTO dto) {
        if (!restriccionMedicaRepository.existsById(id)) {
            throw new RuntimeException("Restricción médica no encontrada con id: " + id);
        }
        Miembro miembro = miembroRepository.findById(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getMiembroCedula()));
        RestriccionMedica restriccion = mm.map(dto, RestriccionMedica.class);
        restriccion.setIdRestriccion(id);
        restriccion.setMiembro(miembro);
        return toResponseDTO(restriccionMedicaRepository.save(restriccion));
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
    public List<RestriccionMedicaResponseDTO> buscarPorMiembro(String cedula) {
        return restriccionMedicaRepository.findByMiembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedicaResponseDTO> buscarPorNivelGravedad(NivelGravedad nivel) {
        return restriccionMedicaRepository.findByNivelGravedad(nivel).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestriccionMedicaResponseDTO> buscarPorTipo(TipoRestriccion tipo) {
        return restriccionMedicaRepository.findByTipo(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private RestriccionMedicaResponseDTO toResponseDTO(RestriccionMedica r) {
        RestriccionMedicaResponseDTO dto = mm.map(r, RestriccionMedicaResponseDTO.class);
        if (r.getMiembro() != null) {
            dto.setMiembroCedula(r.getMiembro().getCedula());
        }
        return dto;
    }
}
