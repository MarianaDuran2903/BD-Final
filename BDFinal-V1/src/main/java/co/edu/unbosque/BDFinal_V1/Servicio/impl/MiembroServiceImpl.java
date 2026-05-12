package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Miembro;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import co.edu.unbosque.BDFinal_V1.Repositorio.MiembroRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MiembroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MiembroServiceImpl implements MiembroService {

    private final MiembroRepository miembroRepository;

    public MiembroServiceImpl(MiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> listarTodos() {
        return miembroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Miembro> buscarPorCedula(String cedula) {
        return miembroRepository.findById(cedula);
    }

    @Override
    public Miembro guardar(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @Override
    public Miembro actualizar(String cedula, Miembro miembro) {
        if (!miembroRepository.existsById(cedula)) {
            throw new RuntimeException("Miembro no encontrado con cédula: " + cedula);
        }
        miembro.setCedula(cedula);
        return miembroRepository.save(miembro);
    }

    @Override
    public void eliminar(String cedula) {
        if (!miembroRepository.existsById(cedula)) {
            throw new RuntimeException("Miembro no encontrado con cédula: " + cedula);
        }
        miembroRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> buscarPorNivelExperiencia(NivelExperiencia nivel) {
        return miembroRepository.findByNivelExperiencia(nivel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> buscarPorRangoAltura(Short min, Short max) {
        return miembroRepository.findByAlturaBetween(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> buscarPorRangoPeso(BigDecimal min, BigDecimal max) {
        return miembroRepository.findByPesoActualBetween(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeMiembro(String cedula) {
        return miembroRepository.existsById(cedula);
    }
}
