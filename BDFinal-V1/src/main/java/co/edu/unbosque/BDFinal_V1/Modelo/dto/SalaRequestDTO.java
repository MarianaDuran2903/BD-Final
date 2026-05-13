package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class SalaRequestDTO {

    @NotNull @Positive
    private Short capacidad;

    public SalaRequestDTO() {}

    public SalaRequestDTO(Short capacidad) {
        this.capacidad = capacidad;
    }

    public Short getCapacidad() { return capacidad; }
    public void setCapacidad(Short capacidad) { this.capacidad = capacidad; }
}
