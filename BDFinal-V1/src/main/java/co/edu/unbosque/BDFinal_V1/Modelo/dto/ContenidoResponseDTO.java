package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import java.time.LocalDate;

public class ContenidoResponseDTO {

    private Integer idContenido;
    private String titulo;
    private String descripcion;
    private TipoContenido tipoContenido;
    private Integer duracion;
    private String urlDelRecurso;
    private LocalDate fechaPublicacion;
    private String autor;

    private DeporteResponseDTO deporte;

    public ContenidoResponseDTO() {}

    public Integer getIdContenido() { return idContenido; }
    public void setIdContenido(Integer idContenido) { this.idContenido = idContenido; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public TipoContenido getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(TipoContenido tipoContenido) { this.tipoContenido = tipoContenido; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public String getUrlDelRecurso() { return urlDelRecurso; }
    public void setUrlDelRecurso(String urlDelRecurso) { this.urlDelRecurso = urlDelRecurso; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public DeporteResponseDTO getDeporte() { return deporte; }
    public void setDeporte(DeporteResponseDTO deporte) { this.deporte = deporte; }
}
