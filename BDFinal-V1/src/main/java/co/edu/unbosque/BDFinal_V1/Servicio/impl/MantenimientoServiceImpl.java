package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Mantenimiento;
import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MantenimientoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.MaquinasRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MantenimientoRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.OperadorRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MantenimientoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final OperadorRepository operadorRepository;
    private final MaquinasRepository maquinasRepository;

    public MantenimientoServiceImpl(MantenimientoRepository mantenimientoRepository,
                                    OperadorRepository operadorRepository,
                                    MaquinasRepository maquinasRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
        this.operadorRepository = operadorRepository;
        this.maquinasRepository = maquinasRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDTO> listarTodos() {
        return mantenimientoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MantenimientoResponseDTO> buscarPorId(MantenimientoId id) {
        return mantenimientoRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public MantenimientoResponseDTO registrar(MantenimientoRequestDTO dto) {
        Operador operador = operadorRepository.findById(dto.getOperadorCedula())
                .orElseThrow(() -> new RuntimeException("Operador no encontrado: " + dto.getOperadorCedula()));
        Maquinas maquina = maquinasRepository.findById(dto.getCodigoSerieMaquina())
                .orElseThrow(() -> new RuntimeException("Máquina no encontrada: " + dto.getCodigoSerieMaquina()));

        MantenimientoId id = new MantenimientoId(dto.getOperadorCedula(), dto.getCodigoSerieMaquina());
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElse(new Mantenimiento());
        mantenimiento.setId(id);
        mantenimiento.setOperador(operador);
        mantenimiento.setMaquina(maquina);
        mantenimiento.setTipoMant(dto.getTipoMant());
        mantenimiento.setFechaMantenimiento(dto.getFechaMantenimiento());
        mantenimiento.setDescripcionMant(dto.getDescripcionMant());
        return toResponseDTO(mantenimientoRepository.save(mantenimiento));
    }

    @Override
    public void eliminar(MantenimientoId id) {
        if (!mantenimientoRepository.existsById(id)) {
            throw new RuntimeException("Registro de mantenimiento no encontrado");
        }
        mantenimientoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDTO> buscarPorOperador(String cedula) {
        return mantenimientoRepository.findByOperador_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDTO> buscarPorMaquina(Integer codigoSerie) {
        return mantenimientoRepository.findByMaquina_CodigoSerie(codigoSerie).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDTO> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return mantenimientoRepository.findByFechaMantenimientoBetween(inicio, fin).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MantenimientoResponseDTO> buscarPorTipo(TipoMantenimiento tipo) {
        return mantenimientoRepository.findByTipoMant(tipo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private MantenimientoResponseDTO toResponseDTO(Mantenimiento m) {
        MantenimientoResponseDTO dto = new MantenimientoResponseDTO();
        dto.setOperadorCedula(m.getId().getOperadorCedula());
        dto.setCodigoSerieMaquina(m.getId().getMaquinasCodigoSerie());
        dto.setTipoMant(m.getTipoMant());
        dto.setFechaMantenimiento(m.getFechaMantenimiento());
        dto.setDescripcionMant(m.getDescripcionMant());
        if (m.getOperador() != null && m.getOperador().getPersona() != null) {
            Persona p = m.getOperador().getPersona();
            dto.setNombreOperador(p.getPrimerNombre() + " " + p.getPrimerApellido());
        }
        if (m.getMaquina() != null) {
            dto.setNombreMaquina(m.getMaquina().getNombreMaquina());
        }
        return dto;
    }
}
