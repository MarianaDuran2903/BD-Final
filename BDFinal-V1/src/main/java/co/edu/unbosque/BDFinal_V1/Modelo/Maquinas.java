package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMaquina;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMaquina;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "maquinas")
public class Maquinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_serie")
    private Integer codigoSerie;

    @Column(name = "nombre_maquina", nullable = false, length = 30)
    private String nombreMaquina;

    @Column(nullable = false, length = 30)
    private String modelo;

    @Column(nullable = false, length = 30)
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_maquina", nullable = false)
    private TipoMaquina tipoMaquina;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMaquina estado;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal capacidad;

    @OneToMany(mappedBy = "maquina")
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public Maquinas() {}

    public Maquinas(Integer codigoSerie, String nombreMaquina, String modelo, String marca,
                    TipoMaquina tipoMaquina, EstadoMaquina estado, BigDecimal capacidad) {
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

    public List<Mantenimiento> getMantenimientos() { return mantenimientos; }
    public void setMantenimientos(List<Mantenimiento> mantenimientos) { this.mantenimientos = mantenimientos; }
}
