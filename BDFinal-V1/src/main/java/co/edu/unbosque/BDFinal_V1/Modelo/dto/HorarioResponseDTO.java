package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioResponseDTO {

    private Integer idHorario;
    private DisponibilidadHorario disponibilidad;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalDate fecha;

    public HorarioResponseDTO() {}

    public HorarioResponseDTO(Integer idHorario, DisponibilidadHorario disponibilidad,
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
}
