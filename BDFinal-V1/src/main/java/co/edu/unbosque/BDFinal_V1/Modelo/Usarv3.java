package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Usarv3")
public class Usarv3 {

    @EmbeddedId
    private Usarv3Id id;

    @ManyToOne
    @JoinColumn(name = "Equipamiento_id_equipamiento", insertable = false, updatable = false)
    private Equipamiento equipamiento;

    @ManyToOne
    @JoinColumn(name = "CLASE_id_clase", insertable = false, updatable = false)
    private Clase clase;

    @Column(name = "cantidad_equipo", nullable = false)
    private Short cantidadEquipo;

    public Usarv3() {}

    public Usarv3(Usarv3Id id, Equipamiento equipamiento, Clase clase, Short cantidadEquipo) {
        this.id = id;
        this.equipamiento = equipamiento;
        this.clase = clase;
        this.cantidadEquipo = cantidadEquipo;
    }

    public Usarv3Id getId() { return id; }
    public void setId(Usarv3Id id) { this.id = id; }

    public Equipamiento getEquipamiento() { return equipamiento; }
    public void setEquipamiento(Equipamiento equipamiento) { this.equipamiento = equipamiento; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }

    public Short getCantidadEquipo() { return cantidadEquipo; }
    public void setCantidadEquipo(Short cantidadEquipo) { this.cantidadEquipo = cantidadEquipo; }
}
