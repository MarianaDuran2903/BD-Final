package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PlanRequestDTO {

    @NotNull
    private DuracionPlan duracion;

    @NotNull @DecimalMin("0.01") @Digits(integer = 8, fraction = 2)
    private BigDecimal precio;

    public PlanRequestDTO() {}

    public PlanRequestDTO(DuracionPlan duracion, BigDecimal precio) {
        this.duracion = duracion;
        this.precio = precio;
    }

    public DuracionPlan getDuracion() { return duracion; }
    public void setDuracion(DuracionPlan duracion) { this.duracion = duracion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
}
