package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExigencia;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoEntrenamiento;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class EntrenadorRequestDTO {

    @NotBlank @Size(max = 15)
    private String cedula;

    @NotBlank @Size(max = 20)
    private String telefono;

    @NotBlank @Email @Size(max = 50)
    private String correo;

    @Size(max = 255)
    private String password;

    @NotBlank @Size(max = 15)
    private String primerNombre;

    @Size(max = 15)
    private String segundoNombre;

    @NotBlank @Size(max = 15)
    private String primerApellido;

    @NotBlank @Size(max = 15)
    private String segundoApellido;

    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private TipoEntrenamiento tipoEntrenamiento;

    @NotNull @Positive
    private Short tiempoExperiencia;

    @NotNull
    private NivelExigencia nivelExigencia;

    @NotNull
    private LocalDate fechaIngresoSis;

    private List<Integer> deportesIds;

    public EntrenadorRequestDTO() {}

    public EntrenadorRequestDTO(String cedula, String telefono, String correo, String password,
                                String primerNombre, String segundoNombre, String primerApellido,
                                String segundoApellido, LocalDate fechaNacimiento,
                                TipoEntrenamiento tipoEntrenamiento, Short tiempoExperiencia,
                                NivelExigencia nivelExigencia, LocalDate fechaIngresoSis,
                                List<Integer> deportesIds) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.tiempoExperiencia = tiempoExperiencia;
        this.nivelExigencia = nivelExigencia;
        this.fechaIngresoSis = fechaIngresoSis;
        this.deportesIds = deportesIds;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

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

    public TipoEntrenamiento getTipoEntrenamiento() { return tipoEntrenamiento; }
    public void setTipoEntrenamiento(TipoEntrenamiento tipoEntrenamiento) { this.tipoEntrenamiento = tipoEntrenamiento; }

    public Short getTiempoExperiencia() { return tiempoExperiencia; }
    public void setTiempoExperiencia(Short tiempoExperiencia) { this.tiempoExperiencia = tiempoExperiencia; }

    public NivelExigencia getNivelExigencia() { return nivelExigencia; }
    public void setNivelExigencia(NivelExigencia nivelExigencia) { this.nivelExigencia = nivelExigencia; }

    public LocalDate getFechaIngresoSis() { return fechaIngresoSis; }
    public void setFechaIngresoSis(LocalDate fechaIngresoSis) { this.fechaIngresoSis = fechaIngresoSis; }

    public List<Integer> getDeportesIds() { return deportesIds; }
    public void setDeportesIds(List<Integer> deportesIds) { this.deportesIds = deportesIds; }
}
