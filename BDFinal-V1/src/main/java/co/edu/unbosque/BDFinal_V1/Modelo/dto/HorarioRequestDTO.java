package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DisponibilidadHorario;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioRequestDTO {

    @NotNull
    private DisponibilidadHorario disponibilidad;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFin;

    @NotNull
    private LocalDate fecha;

    public HorarioRequestDTO() {}

    public HorarioRequestDTO(DisponibilidadHorario disponibilidad, LocalTime horaInicio,
                             LocalTime horaFin, LocalDate fecha) {
        this.disponibilidad = disponibilidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
    }

    public DisponibilidadHorario getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(DisponibilidadHorario disponibilidad) { this.disponibilidad = disponibilidad; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
