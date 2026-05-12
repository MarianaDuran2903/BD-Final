package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface EntrenadorRepository extends JpaRepository<Entrenador, String> {

    List<Entrenador> findByTipoEntrenamiento(String tipoEntrenamiento);

    List<Entrenador> findByNivelExigencia(String nivelExigencia);
}