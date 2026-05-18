package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoMantenimiento;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @EmbeddedId
    private MantenimientoId id;

    @ManyToOne
    @JoinColumn(name = "OPERADOR_cedula", insertable = false, updatable = false)
    private Operador operador;

    @ManyToOne
    @JoinColumn(name = "MAQUINAS_codigo_serie", insertable = false, updatable = false)
    private Maquinas maquina;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mant", nullable = false)
    private TipoMantenimiento tipoMant;

    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDate fechaMantenimiento;

    @Column(name = "descripcion_mant", nullable = false, columnDefinition = "TEXT")
    private String descripcionMant;

    public Mantenimiento() {}

    public Mantenimiento(MantenimientoId id, Operador operador, Maquinas maquina,
                         TipoMantenimiento tipoMant, LocalDate fechaMantenimiento, String descripcionMant) {
        this.id = id;
        this.operador = operador;
        this.maquina = maquina;
        this.tipoMant = tipoMant;
        this.fechaMantenimiento = fechaMantenimiento;
        this.descripcionMant = descripcionMant;
    }

    public MantenimientoId getId() { return id; }
    public void setId(MantenimientoId id) { this.id = id; }

    public Operador getOperador() { return operador; }
    public void setOperador(Operador operador) { this.operador = operador; }

    public Maquinas getMaquina() { return maquina; }
    public void setMaquina(Maquinas maquina) { this.maquina = maquina; }

    public TipoMantenimiento getTipoMant() { return tipoMant; }
    public void setTipoMant(TipoMantenimiento tipoMant) { this.tipoMant = tipoMant; }

    public LocalDate getFechaMantenimiento() { return fechaMantenimiento; }
    public void setFechaMantenimiento(LocalDate fechaMantenimiento) { this.fechaMantenimiento = fechaMantenimiento; }

    public String getDescripcionMant() { return descripcionMant; }
    public void setDescripcionMant(String descripcionMant) { this.descripcionMant = descripcionMant; }
}
