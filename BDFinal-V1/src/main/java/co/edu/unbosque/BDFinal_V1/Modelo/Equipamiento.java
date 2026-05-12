package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Equipamiento")
public class Equipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamiento")
    private Integer idEquipamiento;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(nullable = false)
    private Integer cantidad;

    @OneToMany(mappedBy = "equipamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usarv3> usos = new ArrayList<>();

    public Equipamiento() {}

    public Equipamiento(Integer idEquipamiento, String nombre, String descripcion, Integer cantidad) {
        this.idEquipamiento = idEquipamiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public List<Usarv3> getUsos() { return usos; }
    public void setUsos(List<Usarv3> usos) { this.usos = usos; }
}
