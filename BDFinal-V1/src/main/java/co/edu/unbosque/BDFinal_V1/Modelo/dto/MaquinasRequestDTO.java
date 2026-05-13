package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class MaquinasRequestDTO {

    @NotBlank @Size(max = 30)
    private String nombreMaquina;

    @NotBlank @Size(max = 30)
    private String modelo;

    @NotBlank @Size(max = 30)
    private String marca;

    @NotNull
    private TipoMaquina tipoMaquina;

    @NotNull
    private EstadoMaquina estado;

    @NotNull @DecimalMin("0.01") @Digits(integer = 2, fraction = 2)
    private BigDecimal capacidad;

    public MaquinasRequestDTO() {}

    public MaquinasRequestDTO(String nombreMaquina, String modelo, String marca,
                              TipoMaquina tipoMaquina, EstadoMaquina estado, BigDecimal capacidad) {
        this.nombreMaquina = nombreMaquina;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMaquina = tipoMaquina;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public String getNombreMaquina() { return nombreMaquina; }
    public void setNombreMaquina(String nombreMaquina) { this.nombreMaquina = nombreMaquina; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public TipoMaquina getTipoMaquina() { return tipoMaquina; }
    public void setTipoMaquina(TipoMaquina tipoMaquina) { this.tipoMaquina = tipoMaquina; }

    public EstadoMaquina getEstado() { return estado; }
    public void setEstado(EstadoMaquina estado) { this.estado = estado; }

    public BigDecimal getCapacidad() { return capacidad; }
    public void setCapacidad(BigDecimal capacidad) { this.capacidad = capacidad; }
}
