package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Asistir")
public class Asistir {

    @EmbeddedId
    private AsistirId id;

    @ManyToOne
    @JoinColumn(name = "MIEMBRO_cedula", insertable = false, updatable = false)
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "CLASE_id_clase", insertable = false, updatable = false)
    private Clase clase;

    public Asistir() {}

    public Asistir(AsistirId id, Miembro miembro, Clase clase) {
        this.id = id;
        this.miembro = miembro;
        this.clase = clase;
    }

    public AsistirId getId() { return id; }
    public void setId(AsistirId id) { this.id = id; }

    public Miembro getMiembro() { return miembro; }
    public void setMiembro(Miembro miembro) { this.miembro = miembro; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
}
