package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deporte")
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deporte")
    private Integer idDeporte;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @ManyToMany(mappedBy = "deportes")
    private List<Entrenador> entrenadores = new ArrayList<>();

    @OneToMany(mappedBy = "deporte")
    private List<Clase> clases = new ArrayList<>();

    @OneToMany(mappedBy = "deporte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contenido> contenidos = new ArrayList<>();

    public Deporte() {}

    public Deporte(Integer idDeporte, String nombre, String descripcion) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdDeporte() { return idDeporte; }
    public void setIdDeporte(Integer idDeporte) { this.idDeporte = idDeporte; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Entrenador> getEntrenadores() { return entrenadores; }
    public void setEntrenadores(List<Entrenador> entrenadores) { this.entrenadores = entrenadores; }

    public List<Clase> getClases() { return clases; }
    public void setClases(List<Clase> clases) { this.clases = clases; }

    public List<Contenido> getContenidos() { return contenidos; }
    public void setContenidos(List<Contenido> contenidos) { this.contenidos = contenidos; }
}
