package co.edu.unbosque.BDFinal_V1.Modelo;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DuracionPlan duracion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    public Plan() {}

    // Getters y Setters
}
