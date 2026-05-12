package co.edu.unbosque.BDFinal_V1.Modelo;


@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @ManyToOne
    @JoinColumn(name = "MEMBRESIA_id_membresia", nullable = false)
    private Membresia membresia;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "valor_pagado", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPagado;

    public Pago() {}

    // Getters y Setters
}