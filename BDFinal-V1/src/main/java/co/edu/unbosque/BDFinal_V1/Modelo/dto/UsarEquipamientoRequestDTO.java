package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class UsarEquipamientoRequestDTO {

    @NotNull
    private Integer idEquipamiento;

    @NotNull
    private Integer claseIdClase;

    @NotNull @Positive
    private Short cantidadEquipo;

    public UsarEquipamientoRequestDTO() {}

    public UsarEquipamientoRequestDTO(Integer idEquipamiento, Integer claseIdClase, Short cantidadEquipo) {
        this.idEquipamiento = idEquipamiento;
        this.claseIdClase = claseIdClase;
        this.cantidadEquipo = cantidadEquipo;
    }

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public Integer getClaseIdClase() { return claseIdClase; }
    public void setClaseIdClase(Integer claseIdClase) { this.claseIdClase = claseIdClase; }

    public Short getCantidadEquipo() { return cantidadEquipo; }
    public void setCantidadEquipo(Short cantidadEquipo) { this.cantidadEquipo = cantidadEquipo; }
}
