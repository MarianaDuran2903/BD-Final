package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DiaSemana;
import jakarta.validation.constraints.*;
import java.time.LocalTime;

public class HorarioRequestDTO {

    @NotNull
    private DiaSemana diaSemana;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFin;

    public HorarioRequestDTO() {}

    public HorarioRequestDTO(DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public DiaSemana getDiaSemana() { return diaSemana; }
    public void setDiaSemana(DiaSemana diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
}