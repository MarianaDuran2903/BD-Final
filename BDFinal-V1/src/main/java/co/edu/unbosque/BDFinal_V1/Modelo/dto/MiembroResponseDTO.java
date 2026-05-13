package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoMembresia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MiembroResponseDTO {

    private String cedula;
    private String telefono;
    private String correo;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private Rol rol;

    private Short altura;
    private BigDecimal pesoActual;
    private NivelExperiencia nivelExperiencia;

    private EstadoMembresia membresiaEstado;
    private String planNombre;

    private List<RestriccionMedicaResponseDTO> restriccionesMedicas;
    private PlanEntrenamientoResponseDTO planEntrenamiento;

    public MiembroResponseDTO() {}

    public String getNombreCompleto() {
        String segundo = (segundoNombre != null && !segundoNombre.isBlank()) ? " " + segundoNombre : "";
        return primerNombre + segundo + " " + primerApellido + " " + segundoApellido;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPrimerNombre() { return primerNombre; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }

    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Short getAltura() { return altura; }
    public void setAltura(Short altura) { this.altura = altura; }

    public BigDecimal getPesoActual() { return pesoActual; }
    public void setPesoActual(BigDecimal pesoActual) { this.pesoActual = pesoActual; }

    public NivelExperiencia getNivelExperiencia() { return nivelExperiencia; }
    public void setNivelExperiencia(NivelExperiencia nivelExperiencia) { this.nivelExperiencia = nivelExperiencia; }

    public EstadoMembresia getMembresiaEstado() { return membresiaEstado; }
    public void setMembresiaEstado(EstadoMembresia membresiaEstado) { this.membresiaEstado = membresiaEstado; }

    public String getPlanNombre() { return planNombre; }
    public void setPlanNombre(String planNombre) { this.planNombre = planNombre; }

    public List<RestriccionMedicaResponseDTO> getRestriccionesMedicas() { return restriccionesMedicas; }
    public void setRestriccionesMedicas(List<RestriccionMedicaResponseDTO> restriccionesMedicas) { this.restriccionesMedicas = restriccionesMedicas; }

    public PlanEntrenamientoResponseDTO getPlanEntrenamiento() { return planEntrenamiento; }
    public void setPlanEntrenamiento(PlanEntrenamientoResponseDTO planEntrenamiento) { this.planEntrenamiento = planEntrenamiento; }
}
