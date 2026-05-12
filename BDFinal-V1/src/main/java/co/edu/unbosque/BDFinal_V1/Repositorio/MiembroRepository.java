package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface MiembroRepository extends JpaRepository<Miembro, String> {

    List<Miembro> findByNivelExperiencia(String nivelExperiencia);

    List<Miembro> findByAlturaBetween(Short min, Short max);
}
