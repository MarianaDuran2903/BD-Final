package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import java.math.BigDecimal;

public class MaquinasResponseDTO {

    private Integer codigoSerie;
    private String nombreMaquina;
    private String modelo;
    private String marca;
    private TipoMaquina tipoMaquina;
    private EstadoMaquina estado;
    private BigDecimal capacidad;

    public MaquinasResponseDTO() {}

    public MaquinasResponseDTO(Integer codigoSerie, String nombreMaquina, String modelo,
                               String marca, TipoMaquina tipoMaquina, EstadoMaquina estado,
                               BigDecimal capacidad) {
        this.codigoSerie = codigoSerie;
        this.nombreMaquina = nombreMaquina;
        this.modelo = modelo;
        this.marca = marca;
        this.tipoMaquina = tipoMaquina;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public Integer getCodigoSerie() { return codigoSerie; }
    public void setCodigoSerie(Integer codigoSerie) { this.codigoSerie = codigoSerie; }

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
