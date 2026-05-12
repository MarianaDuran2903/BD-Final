package co.edu.unbosque.BDFinal_V1.Repositorio;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {

    // Req. 13: membresías por estado
    List<Membresia> findByEstado(String estado);

    // Membresías de un miembro
    List<Membresia> findByMiembroCedula(String cedula);

    // Membresía activa de un miembro
    List<Membresia> findByMiembroCedulaAndEstado(String cedula, String estado);
}
