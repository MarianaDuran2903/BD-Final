package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Maquinas;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.MaquinasResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import co.edu.unbosque.BDFinal_V1.Repositorio.MaquinasRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.MaquinasService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MaquinasServiceImpl implements MaquinasService {

    private final MaquinasRepository maquinasRepository;
    private final ModelMapper mm = new ModelMapper();

    public MaquinasServiceImpl(MaquinasRepository maquinasRepository) {
        this.maquinasRepository = maquinasRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaquinasResponseDTO> listarTodas() {
        return maquinasRepository.findAll().stream()
                .map(m -> mm.map(m, MaquinasResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MaquinasResponseDTO> buscarPorId(Integer id) {
        return maquinasRepository.findById(id)
                .map(m -> mm.map(m, MaquinasResponseDTO.class));
    }

    @Override
    public MaquinasResponseDTO guardar(MaquinasRequestDTO dto) {
        Maquinas maquina = mm.map(dto, Maquinas.class);
        return mm.map(maquinasRepository.save(maquina), MaquinasResponseDTO.class);
    }

    @Override
    public MaquinasResponseDTO actualizar(Integer id, MaquinasRequestDTO dto) {
        if (!maquinasRepository.existsById(id)) {
            throw new RuntimeException("Máquina no encontrada con código serie: " + id);
        }
        Maquinas maquina = mm.map(dto, Maquinas.class);
        maquina.setCodigoSerie(id);
        return mm.map(maquinasRepository.save(maquina), MaquinasResponseDTO.class);
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
    public List<MaquinasResponseDTO> buscarPorTipo(TipoMaquina tipo) {
        return maquinasRepository.findByTipoMaquina(tipo).stream()
                .map(m -> mm.map(m, MaquinasResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaquinasResponseDTO> buscarPorEstado(EstadoMaquina estado) {
        return maquinasRepository.findByEstado(estado).stream()
                .map(m -> mm.map(m, MaquinasResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MaquinasResponseDTO cambiarEstado(Integer id, EstadoMaquina nuevoEstado) {
        Maquinas maquina = maquinasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Máquina no encontrada con código serie: " + id));
        maquina.setEstado(nuevoEstado);
        return mm.map(maquinasRepository.save(maquina), MaquinasResponseDTO.class);
    }
}
