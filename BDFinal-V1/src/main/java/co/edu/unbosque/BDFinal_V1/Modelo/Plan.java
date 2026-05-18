package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.DuracionPlan;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DuracionPlan duracion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @OneToMany(mappedBy = "plan")
    private List<Membresia> membresias = new ArrayList<>();

    public Plan() {}

    public Plan(Integer idPlan, DuracionPlan duracion, BigDecimal precio) {
        this.idPlan = idPlan;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Integer getIdPlan() { return idPlan; }
    public void setIdPlan(Integer idPlan) { this.idPlan = idPlan; }

    public DuracionPlan getDuracion() { return duracion; }
    public void setDuracion(DuracionPlan duracion) { this.duracion = duracion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public List<Membresia> getMembresias() { return membresias; }
    public void setMembresias(List<Membresia> membresias) { this.membresias = membresias; }
}
