package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import java.util.List;

public class PlanEntrenamientoResponseDTO {

    private Integer idAsignacion;
    private String cedulaMiembro;
    private String nombreMiembro;
    private String cedulaEntrenador;
    private String nombreEntrenador;
    private String descripcion;
    private List<EjercicioResponseDTO> ejercicios;

    public PlanEntrenamientoResponseDTO() {}

    public Integer getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(Integer idAsignacion) { this.idAsignacion = idAsignacion; }

    public String getCedulaMiembro() { return cedulaMiembro; }
    public void setCedulaMiembro(String cedulaMiembro) { this.cedulaMiembro = cedulaMiembro; }

    public String getNombreMiembro() { return nombreMiembro; }
    public void setNombreMiembro(String nombreMiembro) { this.nombreMiembro = nombreMiembro; }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }

    public String getNombreEntrenador() { return nombreEntrenador; }
    public void setNombreEntrenador(String nombreEntrenador) { this.nombreEntrenador = nombreEntrenador; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<EjercicioResponseDTO> getEjercicios() { return ejercicios; }
    public void setEjercicios(List<EjercicioResponseDTO> ejercicios) { this.ejercicios = ejercicios; }
}
