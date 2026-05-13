package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoResponseDTO {

    private Integer idPago;
    private MetodoPago metodoPago;
    private LocalDate fechaPago;
    private BigDecimal valorPagado;

    private String miembroCedula;
    private String nombreMiembro;
    private String planDuracion;
    private EstadoMembresia estadoMembresia;

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

    public String getPlanDuracion() { return planDuracion; }
    public void setPlanDuracion(String planDuracion) { this.planDuracion = planDuracion; }

    public EstadoMembresia getEstadoMembresia() { return estadoMembresia; }
    public void setEstadoMembresia(EstadoMembresia estadoMembresia) { this.estadoMembresia = estadoMembresia; }
}
