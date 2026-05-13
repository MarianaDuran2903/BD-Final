package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PersonaRequestDTO {

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
    private Rol rol;

    public PersonaRequestDTO() {}

    public PersonaRequestDTO(String cedula, String telefono, String correo, String password,
                             String primerNombre, String segundoNombre, String primerApellido,
                             String segundoApellido, LocalDate fechaNacimiento, Rol rol) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
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

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}
