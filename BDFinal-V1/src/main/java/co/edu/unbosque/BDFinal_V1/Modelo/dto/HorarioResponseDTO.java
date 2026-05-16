package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DiaSemana;
import java.time.LocalTime;

public class HorarioResponseDTO {

    private Integer idHorario;
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorarioResponseDTO() {}

    public HorarioResponseDTO(Integer idHorario, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        this.idHorario = idHorario;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getIdHorario() { return idHorario; }
    public void setIdHorario(Integer idHorario) { this.idHorario = idHorario; }

    public DiaSemana getDiaSemana() { return diaSemana; }
    public void setDiaSemana(DiaSemana diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
}