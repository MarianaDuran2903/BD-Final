package co.edu.unbosque.BDFinal_V1.Modelo;


@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @Column(length = 15)
    private String cedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Column(name = "tipo_entrenamiento", nullable = false)
    private String tipoEntrenamiento;

    @Column(name = "tiempo_experiencia", nullable = false)
    private Short tiempoExperiencia;

    @Column(name = "nivel_exigencia", nullable = false)
    private String nivelExigencia;

    @Column(name = "fecha_ingreso_sis", nullable = false)
    private LocalDate fechaIngresoSis;

    public Entrenador() {}

    // Getters y Setters
}
