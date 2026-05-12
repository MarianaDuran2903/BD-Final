package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Membresia;
import co.edu.unbosque.BDFinal_V1.Modelo.MembresiaId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Repositorio.MembresiaRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MembresiaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembresiaServiceImpl implements MembresiaService {

    private final MembresiaRepository membresiaRepository;

    public MembresiaServiceImpl(MembresiaRepository membresiaRepository) {
        this.membresiaRepository = membresiaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Membresia> listarTodas() {
        return membresiaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Membresia> buscarPorId(MembresiaId id) {
        return membresiaRepository.findById(id);
    }

    @Override
    public Membresia guardar(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Membresia actualizar(MembresiaId id, Membresia membresia) {
        if (!membresiaRepository.existsById(id)) {
            throw new RuntimeException("Membresía no encontrada");
        }
        membresia.setId(id);
        return membresiaRepository.save(membresia);
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
    public List<Membresia> buscarPorMiembro(String cedula) {
        return membresiaRepository.findByMiembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Membresia> buscarPorEstado(EstadoMembresia estado) {
        return membresiaRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Membresia> buscarActivasPorMiembro(String cedula) {
        return membresiaRepository.findByMiembro_CedulaAndEstado(cedula, EstadoMembresia.activa);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Membresia> buscarMembresiaVigente(String cedula) {
        return membresiaRepository.findByMiembro_CedulaAndEstado(cedula, EstadoMembresia.activa)
                .stream()
                .filter(m -> !m.getFechaFin().isBefore(LocalDate.now()))
                .findFirst();
    }
}
