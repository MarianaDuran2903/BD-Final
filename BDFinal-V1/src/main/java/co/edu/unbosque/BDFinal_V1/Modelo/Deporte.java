package co.edu.unbosque.BDFinal_V1.Modelo;

@Entity
@Table(name = "deporte")
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deporte")
    private Integer idDeporte;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    public Deporte() {}

    // Getters y Setters
}