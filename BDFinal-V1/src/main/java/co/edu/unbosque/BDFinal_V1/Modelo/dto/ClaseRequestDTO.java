package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;
import jakarta.validation.constraints.*;

public class ClaseRequestDTO {

    @NotNull
    private EstadoClase estado;

    @NotBlank
    private String comentario;

    @NotNull @Positive
    private Short cupos;

    @NotNull
    private Integer idSala;

    @NotNull
    private Integer idHorario;

    @NotNull
    private Integer idDeporte;

    @NotBlank @Size(max = 15)
    private String cedulaEntrenador;

    public ClaseRequestDTO() {}

    public ClaseRequestDTO(EstadoClase estado, String comentario, Short cupos,
                           Integer idSala, Integer idHorario, Integer idDeporte,
                           String cedulaEntrenador) {
        this.estado = estado;
        this.comentario = comentario;
        this.cupos = cupos;
        this.idSala = idSala;
        this.idHorario = idHorario;
        this.idDeporte = idDeporte;
        this.cedulaEntrenador = cedulaEntrenador;
    }

    public EstadoClase getEstado() { return estado; }
    public void setEstado(EstadoClase estado) { this.estado = estado; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Short getCupos() { return cupos; }
    public void setCupos(Short cupos) { this.cupos = cupos; }

    public Integer getIdSala() { return idSala; }
    public void setIdSala(Integer idSala) { this.idSala = idSala; }

    public Integer getIdHorario() { return idHorario; }
    public void setIdHorario(Integer idHorario) { this.idHorario = idHorario; }

    public Integer getIdDeporte() { return idDeporte; }
    public void setIdDeporte(Integer idDeporte) { this.idDeporte = idDeporte; }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }
}
