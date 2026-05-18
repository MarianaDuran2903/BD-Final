package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.Plan;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MembresiaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PlanResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Repositorio.MembresiaRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PlanRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MembresiaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembresiaServiceImpl implements MembresiaService {

    private final MembresiaRepository membresiaRepository;
    private final MiembroRepository miembroRepository;
    private final PlanRepository planRepository;
    private final ModelMapper mm = new ModelMapper();

    public MembresiaServiceImpl(MembresiaRepository membresiaRepository,
                                MiembroRepository miembroRepository,
                                PlanRepository planRepository) {
        this.membresiaRepository = membresiaRepository;
        this.miembroRepository = miembroRepository;
        this.planRepository = planRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaResponseDTO> listarTodas() {
        return membresiaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaResponseDTO> buscarPorId(MembresiaId id) {
        return membresiaRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public MembresiaResponseDTO guardar(MembresiaRequestDTO dto) {
        MembresiaId id = new MembresiaId(dto.getMiembroCedula(), dto.getIdPlan(), dto.getFechaInicio());

        Optional<Membresia> existing = membresiaRepository.findById(id);
        if (existing.isPresent()) {
            Membresia mem = existing.get();
            if (mem.getEstado() == EstadoMembresia.activa) {
                throw new IllegalStateException("Ya existe una membresía activa con ese plan y fecha de inicio");
            }
            mem.setEstado(dto.getEstado());
            mem.setFechaFin(dto.getFechaFin());
            return toResponseDTO(membresiaRepository.save(mem));
        }

        Miembro miembro = miembroRepository.findById(dto.getMiembroCedula())
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado: " + dto.getMiembroCedula()));
        Plan plan = planRepository.findById(dto.getIdPlan())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado: " + dto.getIdPlan()));

        Membresia membresia = new Membresia();
        membresia.setId(id);
        membresia.setMiembro(miembro);
        membresia.setPlan(plan);
        membresia.setFechaFin(dto.getFechaFin());
        membresia.setEstado(dto.getEstado());
        return toResponseDTO(membresiaRepository.save(membresia));
    }

    @Override
    public MembresiaResponseDTO actualizar(MembresiaId id, MembresiaRequestDTO dto) {
        Membresia membresia = membresiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        membresia.setFechaFin(dto.getFechaFin());
        membresia.setEstado(dto.getEstado());
        return toResponseDTO(membresiaRepository.save(membresia));
    }

    @Override
    public void eliminar(MembresiaId id) {
        if (!membresiaRepository.existsById(id)) {
            throw new RuntimeException("Membresía no encontrada");
        }
        membresiaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaResponseDTO> buscarPorMiembro(String cedula) {
        return membresiaRepository.findByMiembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaResponseDTO> buscarPorEstado(EstadoMembresia estado) {
        return membresiaRepository.findByEstado(estado).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembresiaResponseDTO> buscarActivasPorMiembro(String cedula) {
        return membresiaRepository.findByMiembro_CedulaAndEstado(cedula, EstadoMembresia.activa).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaResponseDTO> buscarMembresiaVigente(String cedula) {
        return membresiaRepository.findByMiembro_CedulaAndEstado(cedula, EstadoMembresia.activa).stream()
                .filter(m -> !m.getFechaFin().isBefore(LocalDate.now()))
                .findFirst()
                .map(this::toResponseDTO);
    }

    private MembresiaResponseDTO toResponseDTO(Membresia m) {
        MembresiaResponseDTO dto = new MembresiaResponseDTO();
        dto.setMiembroCedula(m.getId().getMiembroCedula());
        dto.setFechaInicio(m.getId().getFechaInicio());
        dto.setFechaFin(m.getFechaFin());
        dto.setEstado(m.getEstado());
        if (m.getMiembro() != null && m.getMiembro().getPersona() != null) {
            Persona p = m.getMiembro().getPersona();
            dto.setNombreMiembro(p.getPrimerNombre() + " " + p.getPrimerApellido());
        }
        if (m.getPlan() != null) {
            dto.setPlan(mm.map(m.getPlan(), PlanResponseDTO.class));
        }
        if (m.getPagos() != null && !m.getPagos().isEmpty()) {
            dto.setPagos(m.getPagos().stream()
                    .map(pago -> {
                        PagoResponseDTO pdto = new PagoResponseDTO();
                        pdto.setIdPago(pago.getIdPago());
                        pdto.setMetodoPago(pago.getMetodoPago());
                        pdto.setFechaPago(pago.getFechaPago());
                        pdto.setValorPagado(pago.getValorPagado());
                        pdto.setMiembroCedula(m.getId().getMiembroCedula());
                        pdto.setEstadoMembresia(m.getEstado());
                        if (m.getPlan() != null) pdto.setPlanDuracion(m.getPlan().getDuracion().name());
                        if (m.getMiembro() != null && m.getMiembro().getPersona() != null) {
                            Persona p = m.getMiembro().getPersona();
                            pdto.setNombreMiembro(p.getPrimerNombre() + " " + p.getPrimerApellido());
                        }
                        return pdto;
                    })
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
