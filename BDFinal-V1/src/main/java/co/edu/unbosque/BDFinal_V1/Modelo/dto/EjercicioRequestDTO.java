package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class EjercicioRequestDTO {

    @NotBlank @Size(max = 50)
    private String nombreEjerc;

    @NotBlank @Size(max = 100)
    private String descripcionEjerc;

    @NotNull @Positive
    private Short repsSerie;

    @NotNull @Positive
    private Short numSeries;

    @NotBlank @Size(max = 15)
    private String miembroCedula;

    public EjercicioRequestDTO() {}

    public EjercicioRequestDTO(String nombreEjerc, String descripcionEjerc,
                               Short repsSerie, Short numSeries, String miembroCedula) {
        this.nombreEjerc = nombreEjerc;
        this.descripcionEjerc = descripcionEjerc;
        this.repsSerie = repsSerie;
        this.numSeries = numSeries;
        this.miembroCedula = miembroCedula;
    }

    public String getNombreEjerc() { return nombreEjerc; }
    public void setNombreEjerc(String nombreEjerc) { this.nombreEjerc = nombreEjerc; }

    public String getDescripcionEjerc() { return descripcionEjerc; }
    public void setDescripcionEjerc(String descripcionEjerc) { this.descripcionEjerc = descripcionEjerc; }

    public Short getRepsSerie() { return repsSerie; }
    public void setRepsSerie(Short repsSerie) { this.repsSerie = repsSerie; }

    public Short getNumSeries() { return numSeries; }
    public void setNumSeries(Short numSeries) { this.numSeries = numSeries; }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }
}
