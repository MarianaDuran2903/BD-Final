package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PLAN_ENTRENAMIENTO")
public class PlanEntrenamiento {

    @Id
    @Column(name = "id_asignacion")
    private Integer idAsignacion;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_asignacion")
    private Asignacion asignacion;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "planEntrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejercicios = new ArrayList<>();

    public PlanEntrenamiento() {}

    public Integer getIdAsignacion() { return idAsignacion; }
    public void setIdAsignacion(Integer idAsignacion) { this.idAsignacion = idAsignacion; }

    public Asignacion getAsignacion() { return asignacion; }
    public void setAsignacion(Asignacion asignacion) { this.asignacion = asignacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Ejercicio> getEjercicios() { return ejercicios; }
    public void setEjercicios(List<Ejercicio> ejercicios) { this.ejercicios = ejercicios; }
}
