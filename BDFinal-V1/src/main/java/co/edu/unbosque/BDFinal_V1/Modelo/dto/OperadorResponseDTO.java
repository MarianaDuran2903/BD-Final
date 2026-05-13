package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EspecialidadOperador;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelTecnico;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoOperador;
import java.time.LocalDate;

public class OperadorResponseDTO {

    private String cedula;
    private String telefono;
    private String correo;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private Rol rol;

    private NivelTecnico nivelTecnico;
    private EspecialidadOperador especialidad;
    private TipoOperador tipoOperador;

    public OperadorResponseDTO() {}

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

    public NivelTecnico getNivelTecnico() { return nivelTecnico; }
    public void setNivelTecnico(NivelTecnico nivelTecnico) { this.nivelTecnico = nivelTecnico; }

    public EspecialidadOperador getEspecialidad() { return especialidad; }
    public void setEspecialidad(EspecialidadOperador especialidad) { this.especialidad = especialidad; }

    public TipoOperador getTipoOperador() { return tipoOperador; }
    public void setTipoOperador(TipoOperador tipoOperador) { this.tipoOperador = tipoOperador; }
}
