package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class MembresiaId implements Serializable {

    @Column(name = "MIEMBRO_cedula", length = 15)
    private String miembroCedula;

    @Column(name = "PLAN_id_plan")
    private Integer planIdPlan;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    public MembresiaId() {}

    public MembresiaId(String miembroCedula, Integer planIdPlan, LocalDate fechaInicio) {
        this.miembroCedula = miembroCedula;
        this.planIdPlan = planIdPlan;
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembresiaId)) return false;
        MembresiaId that = (MembresiaId) o;
        return Objects.equals(miembroCedula, that.miembroCedula)
                && Objects.equals(planIdPlan, that.planIdPlan)
                && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miembroCedula, planIdPlan, fechaInicio);
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public Integer getPlanIdPlan() { return planIdPlan; }
    public void setPlanIdPlan(Integer planIdPlan) { this.planIdPlan = planIdPlan; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
}
