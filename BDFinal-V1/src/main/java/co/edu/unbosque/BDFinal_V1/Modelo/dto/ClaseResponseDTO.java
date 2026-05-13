package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.EstadoClase;

public class ClaseResponseDTO {

    private Integer idClase;
    private EstadoClase estado;
    private String comentario;
    private Short cupos;

    private SalaResponseDTO sala;
    private HorarioResponseDTO horario;
    private DeporteResponseDTO deporte;

    private String cedulaEntrenador;
    private String nombreEntrenador;

    public ClaseResponseDTO() {}

    public Integer getIdClase() { return idClase; }
    public void setIdClase(Integer idClase) { this.idClase = idClase; }

    public EstadoClase getEstado() { return estado; }
    public void setEstado(EstadoClase estado) { this.estado = estado; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Short getCupos() { return cupos; }
    public void setCupos(Short cupos) { this.cupos = cupos; }

    public SalaResponseDTO getSala() { return sala; }
    public void setSala(SalaResponseDTO sala) { this.sala = sala; }

    public HorarioResponseDTO getHorario() { return horario; }
    public void setHorario(HorarioResponseDTO horario) { this.horario = horario; }

    public DeporteResponseDTO getDeporte() { return deporte; }
    public void setDeporte(DeporteResponseDTO deporte) { this.deporte = deporte; }

    public String getCedulaEntrenador() { return cedulaEntrenador; }
    public void setCedulaEntrenador(String cedulaEntrenador) { this.cedulaEntrenador = cedulaEntrenador; }

    public String getNombreEntrenador() { return nombreEntrenador; }
    public void setNombreEntrenador(String nombreEntrenador) { this.nombreEntrenador = nombreEntrenador; }
}
