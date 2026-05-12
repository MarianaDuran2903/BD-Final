package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AsistirId implements Serializable {

    @Column(name = "MIEMBRO_cedula", length = 15)
    private String miembroCedula;

    @Column(name = "CLASE_id_clase")
    private Integer claseIdClase;

    @Column(name = "CLASE_id_sala")
    private Integer claseIdSala;

    @Column(name = "CLASE_id_horario")
    private Integer claseIdHorario;

    public AsistirId() {}

    public AsistirId(String miembroCedula, Integer claseIdClase, Integer claseIdSala, Integer claseIdHorario) {
        this.miembroCedula = miembroCedula;
        this.claseIdClase = claseIdClase;
        this.claseIdSala = claseIdSala;
        this.claseIdHorario = claseIdHorario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsistirId)) return false;
        AsistirId that = (AsistirId) o;
        return Objects.equals(miembroCedula, that.miembroCedula)
                && Objects.equals(claseIdClase, that.claseIdClase)
                && Objects.equals(claseIdSala, that.claseIdSala)
                && Objects.equals(claseIdHorario, that.claseIdHorario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miembroCedula, claseIdClase, claseIdSala, claseIdHorario);
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public Integer getClaseIdClase() { return claseIdClase; }
    public void setClaseIdClase(Integer claseIdClase) { this.claseIdClase = claseIdClase; }

    public Integer getClaseIdSala() { return claseIdSala; }
    public void setClaseIdSala(Integer claseIdSala) { this.claseIdSala = claseIdSala; }

    public Integer getClaseIdHorario() { return claseIdHorario; }
    public void setClaseIdHorario(Integer claseIdHorario) { this.claseIdHorario = claseIdHorario; }
}
