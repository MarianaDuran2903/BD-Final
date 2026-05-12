package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    List<Persona> findByRol(Rol rol);

    Optional<Persona> findByCorreo(String correo);

    boolean existsByCorreo(String correo);
}
