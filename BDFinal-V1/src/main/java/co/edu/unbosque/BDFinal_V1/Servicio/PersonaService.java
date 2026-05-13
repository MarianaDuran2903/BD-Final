package co.edu.unbosque.BDFinal_V1.Servicio;

import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaRequestDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.dto.PersonaResponseDTO;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<PersonaResponseDTO> listarTodos();

    Optional<PersonaResponseDTO> buscarPorCedula(String cedula);

    Optional<PersonaResponseDTO> buscarPorCorreo(String correo);

    PersonaResponseDTO guardar(PersonaRequestDTO dto);

    PersonaResponseDTO actualizar(String cedula, PersonaRequestDTO dto);

    void eliminar(String cedula);

    List<PersonaResponseDTO> buscarPorRol(Rol rol);

    boolean existeCorreo(String correo);
}
