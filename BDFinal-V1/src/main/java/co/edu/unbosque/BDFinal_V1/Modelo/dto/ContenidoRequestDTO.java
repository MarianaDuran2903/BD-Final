package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ContenidoRequestDTO {

    @NotBlank @Size(max = 50)
    private String titulo;

    @NotBlank @Size(max = 200)
    private String descripcion;

    @NotNull
    private TipoContenido tipoContenido;

    private Integer duracion;

    @Size(max = 500)
    private String urlDelRecurso;

    @NotNull
    private LocalDate fechaPublicacion;

    @NotBlank @Size(max = 100)
    private String autor;

    @NotNull
    private Integer idDeporte;

    public ContenidoRequestDTO() {}

    public ContenidoRequestDTO(String titulo, String descripcion, TipoContenido tipoContenido,
                               Integer duracion, String urlDelRecurso, LocalDate fechaPublicacion,
                               String autor, Integer idDeporte) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoContenido = tipoContenido;
        this.duracion = duracion;
        this.urlDelRecurso = urlDelRecurso;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.idDeporte = idDeporte;
    }

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

    public Integer getIdDeporte() { return idDeporte; }
    public void setIdDeporte(Integer idDeporte) { this.idDeporte = idDeporte; }
}
