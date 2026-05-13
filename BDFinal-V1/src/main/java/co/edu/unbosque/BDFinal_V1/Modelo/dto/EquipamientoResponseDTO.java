package co.edu.unbosque.BDFinal_V1.Modelo.dto;

public class EquipamientoResponseDTO {

    private Integer idEquipamiento;
    private String nombre;
    private String descripcion;
    private Integer cantidad;

    public EquipamientoResponseDTO() {}

    public EquipamientoResponseDTO(Integer idEquipamiento, String nombre,
                                   String descripcion, Integer cantidad) {
        this.idEquipamiento = idEquipamiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
