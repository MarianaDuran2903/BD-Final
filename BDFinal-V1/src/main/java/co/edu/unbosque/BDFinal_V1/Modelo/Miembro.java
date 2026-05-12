package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MIEMBRO")
public class Miembro {

    @Id
    @Column(length = 15)
    private String cedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Column(nullable = false)
    private Short altura;

    @Column(name = "peso_actual", nullable = false, precision = 5, scale = 2)
    private BigDecimal pesoActual;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_experiencia", nullable = false)
    private NivelExperiencia nivelExperiencia;

    @OneToMany(mappedBy = "miembro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membresia> membresias = new ArrayList<>();

    @OneToMany(mappedBy = "miembro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestriccionMedica> restriccionesMedicas = new ArrayList<>();

    @OneToOne(mappedBy = "miembro", cascade = CascadeType.ALL, orphanRemoval = true)
    private PlanEntrenamiento planEntrenamiento;

    public Miembro() {}

    public Miembro(String cedula, Persona persona, Short altura, BigDecimal pesoActual, NivelExperiencia nivelExperiencia) {
        this.cedula = cedula;
        this.persona = persona;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.nivelExperiencia = nivelExperiencia;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Short getAltura() { return altura; }
    public void setAltura(Short altura) { this.altura = altura; }

    public BigDecimal getPesoActual() { return pesoActual; }
    public void setPesoActual(BigDecimal pesoActual) { this.pesoActual = pesoActual; }

    public NivelExperiencia getNivelExperiencia() { return nivelExperiencia; }
    public void setNivelExperiencia(NivelExperiencia nivelExperiencia) { this.nivelExperiencia = nivelExperiencia; }

    public List<Membresia> getMembresias() { return membresias; }
    public void setMembresias(List<Membresia> membresias) { this.membresias = membresias; }

    public List<RestriccionMedica> getRestriccionesMedicas() { return restriccionesMedicas; }
    public void setRestriccionesMedicas(List<RestriccionMedica> restriccionesMedicas) { this.restriccionesMedicas = restriccionesMedicas; }

    public PlanEntrenamiento getPlanEntrenamiento() { return planEntrenamiento; }
    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) { this.planEntrenamiento = planEntrenamiento; }
}
