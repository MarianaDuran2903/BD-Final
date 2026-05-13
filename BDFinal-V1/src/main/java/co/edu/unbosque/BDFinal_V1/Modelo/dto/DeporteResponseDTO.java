package co.edu.unbosque.BDFinal_V1.Modelo.dto;

public class DeporteResponseDTO {

    private Integer idDeporte;
    private String nombre;
    private String descripcion;

    public DeporteResponseDTO() {}

    public DeporteResponseDTO(Integer idDeporte, String nombre, String descripcion) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdDeporte() { return idDeporte; }
    public void setIdDeporte(Integer idDeporte) { this.idDeporte = idDeporte; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
