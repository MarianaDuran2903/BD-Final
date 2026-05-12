package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Pago;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import co.edu.unbosque.BDFinal_V1.Repositorio.PagoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.PagoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pago> buscarPorId(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago registrar(Pago pago) {
        return pagoRepository.save(pago);
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
    public List<Pago> historialPorMiembro(String cedula) {
        return pagoRepository.findByMembresia_Miembro_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return pagoRepository.findByFechaPagoBetween(inicio, fin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> buscarPorMetodoPago(MetodoPago metodo) {
        return pagoRepository.findByMetodoPago(metodo);
    }
}
