package co.edu.unbosque.BDFinal_V1.Modelo;


@Entity
@Table(name = "miembro")
public class Miembro {

    @Id
    @Column(length = 15)
    private String cedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Column(nullable = false)
    private Short altura;

    @Column(name = "peso_actual", nullable = false, precision = 5, scale = 2)
    private BigDecimal pesoActual;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_experiencia", nullable = false)
    private NivelExperiencia nivelExperiencia;

    public Miembro() {}

    // Getters y Setters
}