package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import jakarta.validation.constraints.*;

public class LoginRequestDTO {

    @NotBlank @Email @Size(max = 50)
    private String correo;

    @NotBlank @Size(max = 255)
    private String password;

    public LoginRequestDTO() {}

    public LoginRequestDTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
