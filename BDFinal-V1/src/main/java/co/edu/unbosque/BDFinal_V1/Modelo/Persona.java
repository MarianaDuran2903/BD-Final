package co.edu.unbosque.BDFinal_V1.Modelo;


@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(length = 15)
    private String cedula;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 50)
    private String correo;

    @Column(name = "primer_nombre", nullable = false, length = 15)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 15)
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false, length = 15)
    private String primerApellido;

    @Column(name = "segundo_apellido", nullable = false, length = 15)
    private String segundoApellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    public Persona() {}

    // Getters y Setters
}
