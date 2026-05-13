package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.MetodoPago;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PagoRequestDTO {

    @NotBlank @Size(max = 15)
    private String miembroCedula;

    @NotNull
    private Integer idPlan;

    @NotNull
    private LocalDate fechaInicioMembresia;

    @NotNull
    private MetodoPago metodoPago;

    @NotNull
    private LocalDate fechaPago;

    @NotNull @DecimalMin("0.01") @Digits(integer = 8, fraction = 2)
    private BigDecimal valorPagado;

    public PagoRequestDTO() {}

    public PagoRequestDTO(String miembroCedula, Integer idPlan, LocalDate fechaInicioMembresia,
                          MetodoPago metodoPago, LocalDate fechaPago, BigDecimal valorPagado) {
        this.miembroCedula = miembroCedula;
        this.idPlan = idPlan;
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
        this.valorPagado = valorPagado;
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public Integer getIdPlan() { return idPlan; }
    public void setIdPlan(Integer idPlan) { this.idPlan = idPlan; }

    public LocalDate getFechaInicioMembresia() { return fechaInicioMembresia; }
    public void setFechaInicioMembresia(LocalDate fechaInicioMembresia) { this.fechaInicioMembresia = fechaInicioMembresia; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public BigDecimal getValorPagado() { return valorPagado; }
    public void setValorPagado(BigDecimal valorPagado) { this.valorPagado = valorPagado; }
}
