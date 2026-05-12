package co.edu.unbosque.BDFinal_V1.Modelo;


@Entity
@Table(name = "clase")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Integer idClase;

    @ManyToOne
    @JoinColumn(name = "ENTRENADOR_cedula", nullable = false)
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "DEPORTE_id_deporte", nullable = false)
    private Deporte deporte;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private Short cupos;

    public Clase() {}

    // Getters y Setters
}