package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class MantenimientoRequestDTO {

    @NotBlank @Size(max = 15)
    private String operadorCedula;

    @NotNull
    private Integer codigoSerieMaquina;

    @NotNull
    private TipoMantenimiento tipoMant;

    @NotNull
    private LocalDate fechaMantenimiento;

    @NotBlank
    private String descripcionMant;

    public MantenimientoRequestDTO() {}

    public MantenimientoRequestDTO(String operadorCedula, Integer codigoSerieMaquina,
                                   TipoMantenimiento tipoMant, LocalDate fechaMantenimiento,
                                   String descripcionMant) {
        this.operadorCedula = operadorCedula;
        this.codigoSerieMaquina = codigoSerieMaquina;
        this.tipoMant = tipoMant;
        this.fechaMantenimiento = fechaMantenimiento;
        this.descripcionMant = descripcionMant;
    }

    public String getOperadorCedula() { return operadorCedula; }
    public void setOperadorCedula(String operadorCedula) { this.operadorCedula = operadorCedula; }

    public Integer getCodigoSerieMaquina() { return codigoSerieMaquina; }
    public void setCodigoSerieMaquina(Integer codigoSerieMaquina) { this.codigoSerieMaquina = codigoSerieMaquina; }

    public TipoMantenimiento getTipoMant() { return tipoMant; }
    public void setTipoMant(TipoMantenimiento tipoMant) { this.tipoMant = tipoMant; }

    public LocalDate getFechaMantenimiento() { return fechaMantenimiento; }
    public void setFechaMantenimiento(LocalDate fechaMantenimiento) { this.fechaMantenimiento = fechaMantenimiento; }

    public String getDescripcionMant() { return descripcionMant; }
    public void setDescripcionMant(String descripcionMant) { this.descripcionMant = descripcionMant; }
}
