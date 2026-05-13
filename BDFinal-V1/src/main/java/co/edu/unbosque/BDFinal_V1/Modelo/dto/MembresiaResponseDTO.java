package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import java.time.LocalDate;
import java.util.List;

public class MembresiaResponseDTO {

    private String miembroCedula;
    private String nombreMiembro;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoMembresia estado;

    private PlanResponseDTO plan;
    private List<PagoResponseDTO> pagos;

    public MembresiaResponseDTO() {}

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public String getNombreMiembro() { return nombreMiembro; }
    public void setNombreMiembro(String nombreMiembro) { this.nombreMiembro = nombreMiembro; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public EstadoMembresia getEstado() { return estado; }
    public void setEstado(EstadoMembresia estado) { this.estado = estado; }

    public PlanResponseDTO getPlan() { return plan; }
    public void setPlan(PlanResponseDTO plan) { this.plan = plan; }

    public List<PagoResponseDTO> getPagos() { return pagos; }
    public void setPagos(List<PagoResponseDTO> pagos) { this.pagos = pagos; }
}
