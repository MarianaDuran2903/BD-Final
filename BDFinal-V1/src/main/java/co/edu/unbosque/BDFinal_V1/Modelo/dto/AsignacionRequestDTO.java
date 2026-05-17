package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class AsignacionRequestDTO {

    @NotBlank @Size(max = 15)
    private String cedulaEntrenador;

    @NotBlank @Size(max = 15)
    private String cedulaMiembro;

    @NotNull
    private LocalDate fechaAsignacion;

    public AsignacionRequestDTO() {}

    public AsignacionRequestDTO(String cedulaEntrenador, String cedulaMiembro, LocalDate fechaAsignacion) {
        this.cedulaEntrenador = cedulaEntrenador;
        this.cedulaMiembro = cedulaMiembro;
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }

    public String getCedulaMiembro() { return cedulaMiembro; }
    public void setCedulaMiembro(String cedulaMiembro) { this.cedulaMiembro = cedulaMiembro; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
}
