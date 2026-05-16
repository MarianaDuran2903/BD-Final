package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLASE")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Integer idClase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoClase estado;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private Short cupos;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "Sala_id_sala", nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "Horario_id_horario", nullable = false)
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "DEPORTE_id_deporte", nullable = false)
    private Deporte deporte;

    @ManyToOne
    @JoinColumn(name = "ENTRENADOR_cedula", nullable = false)
    private Entrenador entrenador;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asistir> asistencias = new ArrayList<>();

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usarv3> equipamientosUsados = new ArrayList<>();

    public Clase() {}

    public Clase(Integer idClase, EstadoClase estado, String comentario, Short cupos,
                 LocalDate fecha, Sala sala, Horario horario, Deporte deporte, Entrenador entrenador) {
        this.idClase = idClase;
        this.estado = estado;
        this.comentario = comentario;
        this.cupos = cupos;
        this.fecha = fecha;
        this.sala = sala;
        this.horario = horario;
        this.deporte = deporte;
        this.entrenador = entrenador;
    }

    public Integer getIdClase() { return idClase; }
    public void setIdClase(Integer idClase) { this.idClase = idClase; }

    public EstadoClase getEstado() { return estado; }
    public void setEstado(EstadoClase estado) { this.estado = estado; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Short getCupos() { return cupos; }
    public void setCupos(Short cupos) { this.cupos = cupos; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public Horario getHorario() { return horario; }
    public void setHorario(Horario horario) { this.horario = horario; }

    public Deporte getDeporte() { return deporte; }
    public void setDeporte(Deporte deporte) { this.deporte = deporte; }

    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }

    public List<Asistir> getAsistencias() { return asistencias; }
    public void setAsistencias(List<Asistir> asistencias) { this.asistencias = asistencias; }

    public List<Usarv3> getEquipamientosUsados() { return equipamientosUsados; }
    public void setEquipamientosUsados(List<Usarv3> equipamientosUsados) { this.equipamientosUsados = equipamientosUsados; }
}
