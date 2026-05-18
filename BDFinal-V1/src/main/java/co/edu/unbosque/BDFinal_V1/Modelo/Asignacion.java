package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asignacion", uniqueConstraints = {
    @UniqueConstraint(name = "Asignacion_UNIQUE", columnNames = {"ENTRENADOR_cedula", "MIEMBRO_cedula"})
})
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;

    @ManyToOne
    @JoinColumn(name = "ENTRENADOR_cedula", nullable = false)
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "MIEMBRO_cedula", nullable = false)
    private Miembro miembro;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDate fechaAsignacion;

    @OneToOne(mappedBy = "asignacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private PlanEntrenamiento planEntrenamiento;

    public Asignacion() {}

    public Integer getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(Integer idAsignacion) { this.idAsignacion = idAsignacion; }

    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }

    public Miembro getMiembro() { return miembro; }
    public void setMiembro(Miembro miembro) { this.miembro = miembro; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public PlanEntrenamiento getPlanEntrenamiento() { return planEntrenamiento; }
    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) { this.planEntrenamiento = planEntrenamiento; }
}
