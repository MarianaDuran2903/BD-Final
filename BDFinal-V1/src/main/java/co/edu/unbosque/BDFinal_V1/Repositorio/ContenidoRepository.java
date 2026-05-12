package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    // Req. 17: visualizar contenido de un deporte
    List<Contenido> findByDeporteIdDeporte(Integer idDeporte);

    List<Contenido> findByTipoContenido(String tipoContenido);
}
