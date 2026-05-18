package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @Column(length = 15)
    private String cedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_entrenamiento", nullable = false)
    private TipoEntrenamiento tipoEntrenamiento;

    @Column(name = "tiempo_experiencia", nullable = false)
    private Short tiempoExperiencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_exigencia", nullable = false)
    private NivelExigencia nivelExigencia;

    @Column(name = "fecha_ingreso_sis", nullable = false)
    private LocalDate fechaIngresoSis;

    @ManyToMany
    @JoinTable(
        name = "especializar",
        joinColumns = @JoinColumn(name = "ENTRENADOR_cedula"),
        inverseJoinColumns = @JoinColumn(name = "DEPORTE_id_deporte")
    )
    private List<Deporte> deportes = new ArrayList<>();

    @OneToMany(mappedBy = "entrenador")
    private List<Clase> clases = new ArrayList<>();

    @OneToMany(mappedBy = "entrenador")
    private List<Asignacion> asignaciones = new ArrayList<>();

    public Entrenador() {}

    public Entrenador(String cedula, Persona persona, TipoEntrenamiento tipoEntrenamiento,
                      Short tiempoExperiencia, NivelExigencia nivelExigencia, LocalDate fechaIngresoSis) {
        this.cedula = cedula;
        this.persona = persona;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.tiempoExperiencia = tiempoExperiencia;
        this.nivelExigencia = nivelExigencia;
        this.fechaIngresoSis = fechaIngresoSis;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public TipoEntrenamiento getTipoEntrenamiento() { return tipoEntrenamiento; }
    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) { this.tipoEntrenamiento = tipoEntrenamiento; }

    public Short getTiempoExperiencia() { return tiempoExperiencia; }
    public void setTiempoExperiencia(Short tiempoExperiencia) { this.tiempoExperiencia = tiempoExperiencia; }

    public NivelExigencia getNivelExigencia() { return nivelExigencia; }
    public void setNivelExigencia(NivelExigencia nivelExigencia) { this.nivelExigencia = nivelExigencia; }

    public LocalDate getFechaIngresoSis() { return fechaIngresoSis; }
    public void setFechaIngresoSis(LocalDate fechaIngresoSis) { this.fechaIngresoSis = fechaIngresoSis; }

    public List<Deporte> getDeportes() { return deportes; }
    public void setDeportes(List<Deporte> deportes) { this.deportes = deportes; }

    public List<Clase> getClases() { return clases; }
    public void setClases(List<Clase> clases) { this.clases = clases; }

    public List<Asignacion> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(List<Asignacion> asignaciones) { this.asignaciones = asignaciones; }
}
