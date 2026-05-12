package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "EJERCICIO")
public class Ejercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejercicio")
    private Integer idEjercicio;

    @Column(name = "nombre_ejerc", nullable = false, length = 50)
    private String nombreEjerc;

    @Column(name = "descripcion_ejerc", nullable = false, length = 100)
    private String descripcionEjerc;

    @Column(name = "reps_serie", nullable = false)
    private Short repsSerie;

    @Column(name = "num_series", nullable = false)
    private Short numSeries;

    @ManyToOne
    @JoinColumn(name = "PLAN_ENTRENAMIENTO_MIEMBRO_cedula", nullable = false)
    private PlanEntrenamiento planEntrenamiento;

    public Ejercicio() {}

    public Ejercicio(Integer idEjercicio, String nombreEjerc, String descripcionEjerc,
                     Short repsSerie, Short numSeries, PlanEntrenamiento planEntrenamiento) {
        this.idEjercicio = idEjercicio;
        this.nombreEjerc = nombreEjerc;
        this.descripcionEjerc = descripcionEjerc;
        this.repsSerie = repsSerie;
        this.numSeries = numSeries;
        this.planEntrenamiento = planEntrenamiento;
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

    public PlanEntrenamiento getPlanEntrenamiento() { return planEntrenamiento; }
    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) { this.planEntrenamiento = planEntrenamiento; }
}
