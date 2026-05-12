package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import co.edu.unbosque.BDFinal_V1.Repositorio.MaquinasRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MaquinasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaquinasServiceImpl implements MaquinasService {

    private final MaquinasRepository maquinasRepository;

    public MaquinasServiceImpl(MaquinasRepository maquinasRepository) {
        this.maquinasRepository = maquinasRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maquinas> listarTodas() {
        return maquinasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maquinas> buscarPorId(Integer id) {
        return maquinasRepository.findById(id);
    }

    @Override
    public Maquinas guardar(Maquinas maquina) {
        return maquinasRepository.save(maquina);
    }

    @Override
    public Maquinas actualizar(Integer id, Maquinas maquina) {
        if (!maquinasRepository.existsById(id)) {
            throw new RuntimeException("Máquina no encontrada con código serie: " + id);
        }
        maquina.setCodigoSerie(id);
        return maquinasRepository.save(maquina);
    }

    @Override
    public void eliminar(Integer id) {
        if (!maquinasRepository.existsById(id)) {
            throw new RuntimeException("Máquina no encontrada con código serie: " + id);
        }
        maquinasRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maquinas> buscarPorTipo(TipoMaquina tipo) {
        return maquinasRepository.findByTipoMaquina(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maquinas> buscarPorEstado(EstadoMaquina estado) {
        return maquinasRepository.findByEstado(estado);
    }

    @Override
    public Maquinas cambiarEstado(Integer id, EstadoMaquina nuevoEstado) {
        Maquinas maquina = maquinasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Máquina no encontrada con código serie: " + id));
        maquina.setEstado(nuevoEstado);
        return maquinasRepository.save(maquina);
    }
}
