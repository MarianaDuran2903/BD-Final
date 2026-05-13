package co.edu.unbosque.BDFinal_V1.Modelo.dto;

public class EjercicioResponseDTO {

    private Integer idEjercicio;
    private String nombreEjerc;
    private String descripcionEjerc;
    private Short repsSerie;
    private Short numSeries;
    private String miembroCedula;

    public EjercicioResponseDTO() {}

    public EjercicioResponseDTO(Integer idEjercicio, String nombreEjerc, String descripcionEjerc,
                                Short repsSerie, Short numSeries, String miembroCedula) {
        this.idEjercicio = idEjercicio;
        this.nombreEjerc = nombreEjerc;
        this.descripcionEjerc = descripcionEjerc;
        this.repsSerie = repsSerie;
        this.numSeries = numSeries;
        this.miembroCedula = miembroCedula;
    }

    public Integer getIdEjercicio() { return idEjercicio; }
    public void setIdEjercicio(Integer idEjercicio) { this.idEjercicio = idEjercicio; }

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
