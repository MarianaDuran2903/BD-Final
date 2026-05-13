package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class PlanEntrenamientoRequestDTO {

    @NotBlank @Size(max = 15)
    private String miembroCedula;

    @NotBlank @Size(max = 15)
    private String cedulaEntrenador;

    @NotBlank @Size(max = 100)
    private String descripcion;

    public PlanEntrenamientoRequestDTO() {}

    public PlanEntrenamientoRequestDTO(String miembroCedula, String cedulaEntrenador, String descripcion) {
        this.miembroCedula = miembroCedula;
        this.cedulaEntrenador = cedulaEntrenador;
        this.descripcion = descripcion;
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
