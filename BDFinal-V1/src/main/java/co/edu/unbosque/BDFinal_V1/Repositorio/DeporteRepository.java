package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface DeporteRepository extends JpaRepository<Deporte, Integer> {

    Optional<Deporte> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
