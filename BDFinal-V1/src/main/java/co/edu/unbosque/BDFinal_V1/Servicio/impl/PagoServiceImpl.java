package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.Pago;
import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PagoResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import co.edu.unbosque.BDFinal_V1.Repositorio.MembresiaRepository;
import co.edu.unbosque.BDFinal_V1.Repositorio.PagoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PagoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final MembresiaRepository membresiaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository,
                           MembresiaRepository membresiaRepository) {
        this.pagoRepository = pagoRepository;
        this.membresiaRepository = membresiaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PagoResponseDTO> listarTodos() {
        return pagoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PagoResponseDTO> buscarPorId(Integer id) {
        return pagoRepository.findById(id).map(this::toResponseDTO);
    }

    @Override
    public PagoResponseDTO registrar(PagoRequestDTO dto) {
        MembresiaId membresiaId = new MembresiaId(dto.getMiembroCedula(), dto.getIdPlan(),
                dto.getFechaInicioMembresia());
        Membresia membresia = membresiaRepository.findById(membresiaId)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada para los datos proporcionados"));

        Pago pago = new Pago();
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setFechaPago(dto.getFechaPago());
        pago.setValorPagado(dto.getValorPagado());
        pago.setMembresia(membresia);
        return toResponseDTO(pagoRepository.save(pago));
    }

    @Override
    public void eliminar(Integer id) {
        if (!pagoRepository.existsById(id)) {
            throw new RuntimeException("Pago no encontrado con id: " + id);
        }
        pagoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PagoResponseDTO> historialPorMiembro(String cedula) {
        return pagoRepository.findByMembresia_Miembro_Cedula(cedula).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PagoResponseDTO> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return pagoRepository.findByFechaPagoBetween(inicio, fin).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PagoResponseDTO> buscarPorMetodoPago(MetodoPago metodo) {
        return pagoRepository.findByMetodoPago(metodo.name()).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private PagoResponseDTO toResponseDTO(Pago p) {
        PagoResponseDTO dto = new PagoResponseDTO();
        dto.setIdPago(p.getIdPago());
        dto.setMetodoPago(p.getMetodoPago());
        dto.setFechaPago(p.getFechaPago());
        dto.setValorPagado(p.getValorPagado());
        if (p.getMembresia() != null) {
            Membresia mem = p.getMembresia();
            dto.setMiembroCedula(mem.getId().getMiembroCedula());
            dto.setFechaInicioMembresia(mem.getId().getFechaInicio());
            dto.setFechaFinMembresia(mem.getFechaFin());
            dto.setEstadoMembresia(mem.getEstado());
            if (mem.getPlan() != null) {
                dto.setPlanId(mem.getPlan().getIdPlan());
                dto.setPlanDuracion(mem.getPlan().getDuracion().name());
                dto.setPlanPrecio(mem.getPlan().getPrecio());
            }
            if (mem.getMiembro() != null && mem.getMiembro().getPersona() != null) {
                Persona persona = mem.getMiembro().getPersona();
                dto.setNombreMiembro(persona.getPrimerNombre() + " " + persona.getPrimerApellido());
                dto.setCorreoMiembro(persona.getCorreo());
                dto.setTelefonoMiembro(persona.getTelefono());
            }
        }
        return dto;
    }
}
