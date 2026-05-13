package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class EquipamientoRequestDTO {

    @NotBlank @Size(max = 30)
    private String nombre;

    @NotBlank @Size(max = 200)
    private String descripcion;

    @NotNull @Min(0)
    private Integer cantidad;

    public EquipamientoRequestDTO() {}

    public EquipamientoRequestDTO(String nombre, String descripcion, Integer cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
