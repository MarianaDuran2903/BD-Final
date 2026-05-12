package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import jakarta.persistence.*;

@Entity
@Table(name = "Restriccion_medica")
public class RestriccionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restriccion")
    private Integer idRestriccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoRestriccion tipo;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_gravedad", nullable = false)
    private NivelGravedad nivelGravedad;

    @Column(nullable = false, length = 200)
    private String recomendaciones;

    @ManyToOne
    @JoinColumn(name = "MIEMBRO_cedula", nullable = false)
    private Miembro miembro;

    public RestriccionMedica() {}

    public RestriccionMedica(Integer idRestriccion, TipoRestriccion tipo, String descripcion,
                             NivelGravedad nivelGravedad, String recomendaciones, Miembro miembro) {
        this.idRestriccion = idRestriccion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelGravedad = nivelGravedad;
        this.recomendaciones = recomendaciones;
        this.miembro = miembro;
    }

    public Integer getIdRestriccion() { return idRestriccion; }
    public void setIdRestriccion(Integer idRestriccion) { this.idRestriccion = idRestriccion; }

    public TipoRestriccion getTipo() { return tipo; }
    public void setTipo(TipoRestriccion tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public NivelGravedad getNivelGravedad() { return nivelGravedad; }
    public void setNivelGravedad(NivelGravedad nivelGravedad) { this.nivelGravedad = nivelGravedad; }

    public String getRecomendaciones() { return recomendaciones; }
    public void setRecomendaciones(String recomendaciones) { this.recomendaciones = recomendaciones; }

    public Miembro getMiembro() { return miembro; }
    public void setMiembro(Miembro miembro) { this.miembro = miembro; }
}
