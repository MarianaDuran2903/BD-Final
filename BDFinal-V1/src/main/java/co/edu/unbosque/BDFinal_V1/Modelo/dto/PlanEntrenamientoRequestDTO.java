package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlanEntrenamientoRequestDTO {

    @NotNull
    private Integer idAsignacion;

    @NotBlank @Size(max = 100)
    private String descripcion;

    public PlanEntrenamientoRequestDTO() {}

    public PlanEntrenamientoRequestDTO(Integer idAsignacion, String descripcion) {
        this.idAsignacion = idAsignacion;
        this.descripcion = descripcion;
    }

    public Integer getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(Integer idAsignacion) { this.idAsignacion = idAsignacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
