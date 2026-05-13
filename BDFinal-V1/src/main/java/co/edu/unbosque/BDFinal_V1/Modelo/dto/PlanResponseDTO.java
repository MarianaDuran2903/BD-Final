package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import java.math.BigDecimal;

public class PlanResponseDTO {

    private Integer idPlan;
    private DuracionPlan duracion;
    private BigDecimal precio;

    public PlanResponseDTO() {}

    public PlanResponseDTO(Integer idPlan, DuracionPlan duracion, BigDecimal precio) {
        this.idPlan = idPlan;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Integer getIdPlan() { return idPlan; }
    public void setIdPlan(Integer idPlan) { this.idPlan = idPlan; }

    public DuracionPlan getDuracion() { return duracion; }
    public void setDuracion(DuracionPlan duracion) { this.duracion = duracion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
}
