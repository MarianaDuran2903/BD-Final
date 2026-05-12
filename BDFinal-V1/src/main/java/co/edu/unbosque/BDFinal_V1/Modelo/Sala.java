package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer idSala;

    @Column(nullable = false)
    private Short capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Clase> clases = new ArrayList<>();

    public Sala() {}

    public Sala(Integer idSala, Short capacidad) {
        this.idSala = idSala;
        this.capacidad = capacidad;
    }

    public Integer getIdSala() { return idSala; }
    public void setIdSala(Integer idSala) { this.idSala = idSala; }

    public Short getCapacidad() { return capacidad; }
    public void setCapacidad(Short capacidad) { this.capacidad = capacidad; }

    public List<Clase> getClases() { return clases; }
    public void setClases(List<Clase> clases) { this.clases = clases; }
}
