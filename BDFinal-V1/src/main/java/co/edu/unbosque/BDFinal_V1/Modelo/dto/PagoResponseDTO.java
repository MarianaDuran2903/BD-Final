package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoResponseDTO {

    // Datos del pago
    private Integer idPago;
    private MetodoPago metodoPago;
    private LocalDate fechaPago;
    private BigDecimal valorPagado;

    // Datos del miembro
    private String miembroCedula;
    private String nombreMiembro;
    private String correoMiembro;
    private String telefonoMiembro;

    // Datos de la membresía
    private LocalDate fechaInicioMembresia;
    private LocalDate fechaFinMembresia;
    private EstadoMembresia estadoMembresia;

    // Datos del plan
    private Integer planId;
    private String planDuracion;
    private BigDecimal planPrecio;

    public PagoResponseDTO() {}

    public Integer getIdPago() { return idPago; }
    public void setIdPago(Integer idPago) { this.idPago = idPago; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public BigDecimal getValorPagado() { return valorPagado; }
    public void setValorPagado(BigDecimal valorPagado) { this.valorPagado = valorPagado; }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public String getNombreMiembro() { return nombreMiembro; }
    public void setNombreMiembro(String nombreMiembro) { this.nombreMiembro = nombreMiembro; }

    public String getCorreoMiembro() { return correoMiembro; }
    public void setCorreoMiembro(String correoMiembro) { this.correoMiembro = correoMiembro; }

    public String getTelefonoMiembro() { return telefonoMiembro; }
    public void setTelefonoMiembro(String telefonoMiembro) { this.telefonoMiembro = telefonoMiembro; }

    public LocalDate getFechaInicioMembresia() { return fechaInicioMembresia; }
    public void setFechaInicioMembresia(LocalDate fechaInicioMembresia) { this.fechaInicioMembresia = fechaInicioMembresia; }

    public LocalDate getFechaFinMembresia() { return fechaFinMembresia; }
    public void setFechaFinMembresia(LocalDate fechaFinMembresia) { this.fechaFinMembresia = fechaFinMembresia; }

    public EstadoMembresia getEstadoMembresia() { return estadoMembresia; }
    public void setEstadoMembresia(EstadoMembresia estadoMembresia) { this.estadoMembresia = estadoMembresia; }

    public Integer getPlanId() { return planId; }
    public void setPlanId(Integer planId) { this.planId = planId; }

    public String getPlanDuracion() { return planDuracion; }
    public void setPlanDuracion(String planDuracion) { this.planDuracion = planDuracion; }

    public BigDecimal getPlanPrecio() { return planPrecio; }
    public void setPlanPrecio(BigDecimal planPrecio) { this.planPrecio = planPrecio; }
}
