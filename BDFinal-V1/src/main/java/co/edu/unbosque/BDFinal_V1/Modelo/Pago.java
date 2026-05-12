package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PAGO")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "valor_pagado", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPagado;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "MEMBRESIA_cedula",       referencedColumnName = "MIEMBRO_cedula"),
        @JoinColumn(name = "MEMBRESIA_PLAN_id_plan",  referencedColumnName = "PLAN_id_plan"),
        @JoinColumn(name = "MEMBRESIA_fecha_inicio",  referencedColumnName = "fecha_inicio")
    })
    private Membresia membresia;

    public Pago() {}

    public Pago(Integer idPago, MetodoPago metodoPago, LocalDate fechaPago,
                BigDecimal valorPagado, Membresia membresia) {
        this.idPago = idPago;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
        this.valorPagado = valorPagado;
        this.membresia = membresia;
    }

    public Integer getIdPago() { return idPago; }
    public void setIdPago(Integer idPago) { this.idPago = idPago; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public BigDecimal getValorPagado() { return valorPagado; }
    public void setValorPagado(BigDecimal valorPagado) { this.valorPagado = valorPagado; }

    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
}
