package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import java.time.LocalDate;
import java.util.List;

public class EntrenadorResponseDTO {

    private String cedula;
    private String telefono;
    private String correo;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private Rol rol;

    private TipoEntrenamiento tipoEntrenamiento;
    private Short tiempoExperiencia;
    private NivelExigencia nivelExigencia;
    private LocalDate fechaIngresoSis;

    private List<DeporteResponseDTO> deportes;

    public EntrenadorResponseDTO() {}

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

    public TipoEntrenamiento getTipoEntrenamiento() { return tipoEntrenamiento; }
    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) { this.tipoEntrenamiento = tipoEntrenamiento; }

    public Short getTiempoExperiencia() { return tiempoExperiencia; }
    public void setTiempoExperiencia(Short tiempoExperiencia) { this.tiempoExperiencia = tiempoExperiencia; }

    public NivelExigencia getNivelExigencia() { return nivelExigencia; }
    public void setNivelExigencia(NivelExigencia nivelExigencia) { this.nivelExigencia = nivelExigencia; }

    public LocalDate getFechaIngresoSis() { return fechaIngresoSis; }
    public void setFechaIngresoSis(LocalDate fechaIngresoSis) { this.fechaIngresoSis = fechaIngresoSis; }

    public List<DeporteResponseDTO> getDeportes() { return deportes; }
    public void setDeportes(List<DeporteResponseDTO> deportes) { this.deportes = deportes; }
}
