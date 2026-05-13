package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import java.time.LocalDate;

public class MantenimientoResponseDTO {

    private String operadorCedula;
    private String nombreOperador;
    private Integer codigoSerieMaquina;
    private String nombreMaquina;
    private TipoMantenimiento tipoMant;
    private LocalDate fechaMantenimiento;
    private String descripcionMant;

    public MantenimientoResponseDTO() {}

    public String getOperadorCedula() { return operadorCedula; }
    public void setOperadorCedula(String operadorCedula) { this.operadorCedula = operadorCedula; }

    public String getNombreOperador() { return nombreOperador; }
    public void setNombreOperador(String nombreOperador) { this.nombreOperador = nombreOperador; }

    public Integer getCodigoSerieMaquina() { return codigoSerieMaquina; }
    public void setCodigoSerieMaquina(Integer codigoSerieMaquina) { this.codigoSerieMaquina = codigoSerieMaquina; }

    public String getNombreMaquina() { return nombreMaquina; }
    public void setNombreMaquina(String nombreMaquina) { this.nombreMaquina = nombreMaquina; }

    public TipoMantenimiento getTipoMant() { return tipoMant; }
    public void setTipoMant(TipoMantenimiento tipoMant) { this.tipoMant = tipoMant; }

    public LocalDate getFechaMantenimiento() { return fechaMantenimiento; }
    public void setFechaMantenimiento(LocalDate fechaMantenimiento) { this.fechaMantenimiento = fechaMantenimiento; }

    public String getDescripcionMant() { return descripcionMant; }
    public void setDescripcionMant(String descripcionMant) { this.descripcionMant = descripcionMant; }
}
