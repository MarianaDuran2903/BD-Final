package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

    // Consultar clases por entrenador (Req. 14)
    List<Clase> findByEntrenadorCedula(String cedula);

    // Consultar clases por deporte
    List<Clase> findByDeporteIdDeporte(Integer idDeporte);

    // Consultar clases por estado
    List<Clase> findByEstado(String estado);
}
