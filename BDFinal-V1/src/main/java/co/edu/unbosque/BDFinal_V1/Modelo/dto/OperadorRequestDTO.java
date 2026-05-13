package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelTecnico;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class OperadorRequestDTO {

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

    @NotNull
    private NivelTecnico nivelTecnico;

    @NotNull
    private EspecialidadOperador especialidad;

    @NotNull
    private TipoOperador tipoOperador;

    public OperadorRequestDTO() {}

    public OperadorRequestDTO(String cedula, String telefono, String correo, String password,
                              String primerNombre, String segundoNombre, String primerApellido,
                              String segundoApellido, LocalDate fechaNacimiento,
                              NivelTecnico nivelTecnico, EspecialidadOperador especialidad,
                              TipoOperador tipoOperador) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelTecnico = nivelTecnico;
        this.especialidad = especialidad;
        this.tipoOperador = tipoOperador;
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

    public NivelTecnico getNivelTecnico() { return nivelTecnico; }
    public void setNivelTecnico(NivelTecnico nivelTecnico) { this.nivelTecnico = nivelTecnico; }

    public EspecialidadOperador getEspecialidad() { return especialidad; }
    public void setEspecialidad(EspecialidadOperador especialidad) { this.especialidad = especialidad; }

    public TipoOperador getTipoOperador() { return tipoOperador; }
    public void setTipoOperador(TipoOperador tipoOperador) { this.tipoOperador = tipoOperador; }
}
