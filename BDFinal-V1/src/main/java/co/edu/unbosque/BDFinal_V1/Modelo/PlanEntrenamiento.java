package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PLAN_ENTRENAMIENTO")
public class PlanEntrenamiento {

    @Id
    @Column(name = "MIEMBRO_cedula", length = 15)
    private String miembroCedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "MIEMBRO_cedula")
    private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "ENTRENADOR_cedula", nullable = false)
    private Entrenador entrenador;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "planEntrenamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejercicios = new ArrayList<>();

    public PlanEntrenamiento() {}

    public PlanEntrenamiento(String miembroCedula, Miembro miembro, Entrenador entrenador, String descripcion) {
        this.miembroCedula = miembroCedula;
        this.miembro = miembro;
        this.entrenador = entrenador;
        this.descripcion = descripcion;
    }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }

    public Miembro getMiembro() { return miembro; }
    public void setMiembro(Miembro miembro) { this.miembro = miembro; }

    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Ejercicio> getEjercicios() { return ejercicios; }
    public void setEjercicios(List<Ejercicio> ejercicios) { this.ejercicios = ejercicios; }
}
