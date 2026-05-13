package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelExperiencia;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MiembroRequestDTO {

    @NotBlank @Size(max = 15)
    private String cedula;

    @NotBlank @Size(max = 20)
    private String telefono;

    @NotBlank @Email @Size(max = 50)
    private String correo;

    @NotBlank @Size(max = 255)
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

    @NotNull @Positive
    private Short altura;

    @NotNull @DecimalMin("0.01") @Digits(integer = 3, fraction = 2)
    private BigDecimal pesoActual;

    @NotNull
    private NivelExperiencia nivelExperiencia;

    public MiembroRequestDTO() {}

    public MiembroRequestDTO(String cedula, String telefono, String correo, String password,
                             String primerNombre, String segundoNombre, String primerApellido,
                             String segundoApellido, LocalDate fechaNacimiento,
                             Short altura, BigDecimal pesoActual, NivelExperiencia nivelExperiencia) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.nivelExperiencia = nivelExperiencia;
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

    public Short getAltura() { return altura; }
    public void setAltura(Short altura) { this.altura = altura; }

    public BigDecimal getPesoActual() { return pesoActual; }
    public void setPesoActual(BigDecimal pesoActual) { this.pesoActual = pesoActual; }

    public NivelExperiencia getNivelExperiencia() { return nivelExperiencia; }
    public void setNivelExperiencia(NivelExperiencia nivelExperiencia) { this.nivelExperiencia = nivelExperiencia; }
}
