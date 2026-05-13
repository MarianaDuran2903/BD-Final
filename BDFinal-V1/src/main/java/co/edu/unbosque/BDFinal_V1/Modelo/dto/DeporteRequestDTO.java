package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class DeporteRequestDTO {

    @NotBlank @Size(max = 20)
    private String nombre;

    @NotBlank @Size(max = 100)
    private String descripcion;

    public DeporteRequestDTO() {}

    public DeporteRequestDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
