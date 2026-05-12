package co.edu.unbosque.BDFinal_V1.Servicio.impl;

import co.edu.unbosque.BDFinal_V1.Modelo.Operador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import co.edu.unbosque.BDFinal_V1.Repositorio.OperadorRepository;
import co.edu.unbosque.BDFinal_V1.Servicio.OperadorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OperadorServiceImpl implements OperadorService {

    private final OperadorRepository operadorRepository;

    public OperadorServiceImpl(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operador> listarTodos() {
        return operadorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Operador> buscarPorCedula(String cedula) {
        return operadorRepository.findById(cedula);
    }

    @Override
    public Operador guardar(Operador operador) {
        return operadorRepository.save(operador);
    }

    @Override
    public Operador actualizar(String cedula, Operador operador) {
        if (!operadorRepository.existsById(cedula)) {
            throw new RuntimeException("Operador no encontrado con cédula: " + cedula);
        }
        operador.setCedula(cedula);
        return operadorRepository.save(operador);
    }

    @Override
    public void eliminar(String cedula) {
        if (!operadorRepository.existsById(cedula)) {
            throw new RuntimeException("Operador no encontrado con cédula: " + cedula);
        }
        operadorRepository.deleteById(cedula);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operador> buscarPorTipoOperador(TipoOperador tipo) {
        return operadorRepository.findByTipoOperador(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operador> buscarPorEspecialidad(EspecialidadOperador especialidad) {
        return operadorRepository.findByEspecialidad(especialidad);
    }
}
