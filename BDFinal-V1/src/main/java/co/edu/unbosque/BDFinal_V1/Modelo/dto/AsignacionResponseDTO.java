package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import java.time.LocalDate;

public class AsignacionResponseDTO {

    private Integer idAsignacion;
    private String cedulaEntrenador;
    private String nombreEntrenador;
    private String cedulaMiembro;
    private String nombreMiembro;
    private LocalDate fechaAsignacion;
    private boolean tienePlan;

    public AsignacionResponseDTO() {}

    public Integer getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(Integer idAsignacion) { this.idAsignacion = idAsignacion; }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }

    public String getNombreEntrenador() { return nombreEntrenador; }
    public void setNombreEntrenador(String nombreEntrenador) { this.nombreEntrenador = nombreEntrenador; }

    public String getCedulaMiembro() { return cedulaMiembro; }
    public void setCedulaMiembro(String cedulaMiembro) { this.cedulaMiembro = cedulaMiembro; }

    public String getNombreMiembro() { return nombreMiembro; }
    public void setNombreMiembro(String nombreMiembro) { this.nombreMiembro = nombreMiembro; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public boolean isTienePlan() { return tienePlan; }
    public void setTienePlan(boolean tienePlan) { this.tienePlan = tienePlan; }
}
