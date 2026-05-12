package co.edu.unbosque.BDFinal_V1.Modelo;

@Entity
@Table(name = "membresia")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private Integer idMembresia;

    @ManyToOne
    @JoinColumn(name = "MIEMBRO_cedula", nullable = false)
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "PLAN_id_plan", nullable = false)
    private Plan plan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMembresia estado;

    public Membresia() {}

    // Getters y Setters
}