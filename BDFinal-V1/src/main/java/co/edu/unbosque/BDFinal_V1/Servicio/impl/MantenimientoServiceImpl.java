package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Mantenimiento;
import co.edu.unbosque.BDFinal_V1.Modelo.MantenimientoId;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import co.edu.unbosque.BDFinal_V1.Repositorio.MantenimientoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MantenimientoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    public MantenimientoServiceImpl(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mantenimiento> listarTodos() {
        return mantenimientoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Mantenimiento> buscarPorId(MantenimientoId id) {
        return mantenimientoRepository.findById(id);
    }

    @Override
    public Mantenimiento registrar(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
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
    public List<Mantenimiento> buscarPorOperador(String cedula) {
        return mantenimientoRepository.findByOperador_Cedula(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mantenimiento> buscarPorMaquina(Integer codigoSerie) {
        return mantenimientoRepository.findByMaquina_CodigoSerie(codigoSerie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mantenimiento> buscarPorRangoFechas(LocalDate inicio, LocalDate fin) {
        return mantenimientoRepository.findByFechaMantenimientoBetween(inicio, fin);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mantenimiento> buscarPorTipo(TipoMantenimiento tipo) {
        return mantenimientoRepository.findByTipoMant(tipo);
    }
}
