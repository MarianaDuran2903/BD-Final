package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Usarv3Id implements Serializable {

    @Column(name = "Equipamiento_id_equipamiento")
    private Integer equipamientoId;

    @Column(name = "CLASE_id_clase")
    private Integer claseIdClase;

    @Column(name = "CLASE_Sala_id_sala")
    private Integer claseSalaId;

    @Column(name = "CLASE_Horario_id_horario")
    private Integer claseHorarioId;

    public Usarv3Id() {}

    public Usarv3Id(Integer equipamientoId, Integer claseIdClase, Integer claseSalaId, Integer claseHorarioId) {
        this.equipamientoId = equipamientoId;
        this.claseIdClase = claseIdClase;
        this.claseSalaId = claseSalaId;
        this.claseHorarioId = claseHorarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usarv3Id)) return false;
        Usarv3Id that = (Usarv3Id) o;
        return Objects.equals(equipamientoId, that.equipamientoId)
                && Objects.equals(claseIdClase, that.claseIdClase)
                && Objects.equals(claseSalaId, that.claseSalaId)
                && Objects.equals(claseHorarioId, that.claseHorarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipamientoId, claseIdClase, claseSalaId, claseHorarioId);
    }

    public Integer getEquipamientoId() { return equipamientoId; }
    public void setEquipamientoId(Integer equipamientoId) { this.equipamientoId = equipamientoId; }

    public Integer getClaseIdClase() { return claseIdClase; }
    public void setClaseIdClase(Integer claseIdClase) { this.claseIdClase = claseIdClase; }

    public Integer getClaseSalaId() { return claseSalaId; }
    public void setClaseSalaId(Integer claseSalaId) { this.claseSalaId = claseSalaId; }

    public Integer getClaseHorarioId() { return claseHorarioId; }
    public void setClaseHorarioId(Integer claseHorarioId) { this.claseHorarioId = claseHorarioId; }
}
