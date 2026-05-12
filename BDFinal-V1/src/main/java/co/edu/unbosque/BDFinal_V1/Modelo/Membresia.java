package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBRESIA")
public class Membresia {

    @EmbeddedId
    private MembresiaId id;

    @ManyToOne
    @JoinColumn(name = "MIEMBRO_cedula", insertable = false, updatable = false)
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "PLAN_id_plan", insertable = false, updatable = false)
    private Plan plan;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMembresia estado;

    @OneToMany(mappedBy = "membresia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos = new ArrayList<>();

    public Membresia() {}

    public Membresia(MembresiaId id, Miembro miembro, Plan plan, LocalDate fechaFin, EstadoMembresia estado) {
        this.id = id;
        this.miembro = miembro;
        this.plan = plan;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public MembresiaId getId() { return id; }
    public void setId(MembresiaId id) { this.id = id; }

    public Miembro getMiembro() { return miembro; }
    public void setMiembro(Miembro miembro) { this.miembro = miembro; }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public EstadoMembresia getEstado() { return estado; }
    public void setEstado(EstadoMembresia estado) { this.estado = estado; }

    public List<Pago> getPagos() { return pagos; }
    public void setPagos(List<Pago> pagos) { this.pagos = pagos; }
}
