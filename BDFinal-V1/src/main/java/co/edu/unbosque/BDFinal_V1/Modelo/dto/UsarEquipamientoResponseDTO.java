package co.edu.unbosque.BDFinal_V1.Modelo.dto;

public class UsarEquipamientoResponseDTO {

    private Integer idEquipamiento;
    private String nombreEquipamiento;
    private Integer claseIdClase;
    private String deporteClase;
    private Short cantidadEquipo;

    public UsarEquipamientoResponseDTO() {}

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public String getNombreEquipamiento() { return nombreEquipamiento; }
    public void setNombreEquipamiento(String nombreEquipamiento) { this.nombreEquipamiento = nombreEquipamiento; }

    public Integer getClaseIdClase() { return claseIdClase; }
    public void setClaseIdClase(Integer claseIdClase) { this.claseIdClase = claseIdClase; }

    public String getDeporteClase() { return deporteClase; }
    public void setDeporteClase(String deporteClase) { this.deporteClase = deporteClase; }

    public Short getCantidadEquipo() { return cantidadEquipo; }
    public void setCantidadEquipo(Short cantidadEquipo) { this.cantidadEquipo = cantidadEquipo; }
}
