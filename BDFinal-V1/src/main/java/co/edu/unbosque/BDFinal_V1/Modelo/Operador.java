package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelTecnico;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OPERADOR")
public class Operador {

    @Id
    @Column(length = 15)
    private String cedula;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_tecnico", nullable = false)
    private NivelTecnico nivelTecnico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EspecialidadOperador especialidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_operador", nullable = false)
    private TipoOperador tipoOperador;

    @OneToMany(mappedBy = "operador")
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public Operador() {}

    public Operador(String cedula, Persona persona, NivelTecnico nivelTecnico,
                    EspecialidadOperador especialidad, TipoOperador tipoOperador) {
        this.cedula = cedula;
        this.persona = persona;
        this.nivelTecnico = nivelTecnico;
        this.especialidad = especialidad;
        this.tipoOperador = tipoOperador;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public NivelTecnico getNivelTecnico() { return nivelTecnico; }
    public void setNivelTecnico(NivelTecnico nivelTecnico) { this.nivelTecnico = nivelTecnico; }

    public EspecialidadOperador getEspecialidad() { return especialidad; }
    public void setEspecialidad(EspecialidadOperador especialidad) { this.especialidad = especialidad; }

    public TipoOperador getTipoOperador() { return tipoOperador; }
    public void setTipoOperador(TipoOperador tipoOperador) { this.tipoOperador = tipoOperador; }

    public List<Mantenimiento> getMantenimientos() { return mantenimientos; }
    public void setMantenimientos(List<Mantenimiento> mantenimientos) { this.mantenimientos = mantenimientos; }
}
