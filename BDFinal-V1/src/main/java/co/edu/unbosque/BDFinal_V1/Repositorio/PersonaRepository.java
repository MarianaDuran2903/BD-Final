package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    List<Persona> findByRol(Rol rol);

    boolean existsByCorreo(String correo);
}
