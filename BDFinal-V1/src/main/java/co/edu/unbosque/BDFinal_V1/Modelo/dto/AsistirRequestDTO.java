package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class AsistirRequestDTO {

    @NotBlank @Size(max = 15)
    private String miembroCedula;

    @NotNull
    private Integer claseIdClase;

    public AsistirRequestDTO() {}

    public AsistirRequestDTO(String miembroCedula, Integer claseIdClase) {
        this.miembroCedula = miembroCedula;
        this.claseIdClase = claseIdClase;
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public Integer getClaseIdClase() { return claseIdClase; }
    public void setClaseIdClase(Integer claseIdClase) { this.claseIdClase = claseIdClase; }
}
