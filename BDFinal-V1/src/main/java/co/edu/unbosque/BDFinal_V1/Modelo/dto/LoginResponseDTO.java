package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.Rol;

public class LoginResponseDTO {

    private String cedula;
    private String nombreCompleto;
    private String correo;
    private Rol rol;
    private Object perfilCompleto;
    private String token;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String cedula, String nombreCompleto, String correo,
                            Rol rol, Object perfilCompleto, String token) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.rol = rol;
        this.perfilCompleto = perfilCompleto;
        this.token = token;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Object getPerfilCompleto() { return perfilCompleto; }
    public void setPerfilCompleto(Object perfilCompleto) { this.perfilCompleto = perfilCompleto; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
