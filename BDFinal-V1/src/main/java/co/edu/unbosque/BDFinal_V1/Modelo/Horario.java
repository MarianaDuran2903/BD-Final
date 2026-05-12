package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Integer idHorario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisponibilidadHorario disponibilidad;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "horario")
    private List<Clase> clases = new ArrayList<>();

    public Horario() {}

    public Horario(Integer idHorario, DisponibilidadHorario disponibilidad,
                   LocalTime horaInicio, LocalTime horaFin, LocalDate fecha) {
        this.idHorario = idHorario;
        this.disponibilidad = disponibilidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    public Integer getIdHorario() { return idHorario; }
    public void setIdHorario(Integer idHorario) { this.idHorario = idHorario; }

    public DisponibilidadHorario getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(DisponibilidadHorario disponibilidad) { this.disponibilidad = disponibilidad; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public List<Clase> getClases() { return clases; }
    public void setClases(List<Clase> clases) { this.clases = clases; }
}
