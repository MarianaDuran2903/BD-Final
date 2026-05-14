package co.edu.unbosque.BDFinal_V1.Repositorio;

import co.edu.unbosque.BDFinal_V1.Modelo.Persona;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    @Query(value = "SELECT * FROM PERSONA", nativeQuery = true)
    List<Persona> findAll();

    @Query(value = "SELECT * FROM PERSONA WHERE cedula = :id", nativeQuery = true)
    Optional<Persona> findById(@Param("id") String id);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Persona p WHERE p.cedula = :id")
    boolean existsById(@Param("id") String id);

    @Query(value = "SELECT * FROM PERSONA WHERE rol = :rol", nativeQuery = true)
    List<Persona> findByRol(@Param("rol") Rol rol);

    @Query(value = "SELECT * FROM PERSONA WHERE correo = :correo", nativeQuery = true)
    Optional<Persona> findByCorreo(@Param("correo") String correo);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Persona p WHERE p.correo = :correo")
    boolean existsByCorreo(@Param("correo") String correo);

    @Modifying
    @Query(value = "DELETE FROM PERSONA WHERE cedula = :cedula", nativeQuery = true)
    void deleteByCedula(@Param("cedula") String cedula);
}