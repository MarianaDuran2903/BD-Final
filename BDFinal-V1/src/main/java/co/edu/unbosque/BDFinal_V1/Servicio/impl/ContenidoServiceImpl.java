package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Contenido;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import co.edu.unbosque.BDFinal_V1.Repositorio.ContenidoRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.ContenidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContenidoServiceImpl implements ContenidoService {

    private final ContenidoRepository contenidoRepository;

    public ContenidoServiceImpl(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contenido> listarTodos() {
        return contenidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contenido> buscarPorId(Integer id) {
        return contenidoRepository.findById(id);
    }

    @Override
    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    @Override
    public Contenido actualizar(Integer id, Contenido contenido) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado con id: " + id);
        }
        contenido.setIdContenido(id);
        return contenidoRepository.save(contenido);
    }

    @Override
    public void eliminar(Integer id) {
        if (!contenidoRepository.existsById(id)) {
            throw new RuntimeException("Contenido no encontrado con id: " + id);
        }
        contenidoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contenido> buscarPorDeporte(Integer idDeporte) {
        return contenidoRepository.findByDeporte_IdDeporte(idDeporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contenido> buscarPorTipo(TipoContenido tipo) {
        return contenidoRepository.findByTipoContenido(tipo);
    }
}
