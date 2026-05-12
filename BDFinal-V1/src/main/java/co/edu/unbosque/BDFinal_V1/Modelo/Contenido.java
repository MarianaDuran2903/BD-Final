package co.edu.unbosque.BDFinal_V1.Modelo;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoContenido;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CONTENIDO")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido")
    private Integer idContenido;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contenido", nullable = false)
    private TipoContenido tipoContenido;

    @Column
    private Integer duracion;

    @Column(name = "url_del_recurso", length = 500)
    private String urlDelRecurso;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(nullable = false, length = 100)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "DEPORTE_id_deporte", nullable = false)
    private Deporte deporte;

    public Contenido() {}

    public Contenido(Integer idContenido, String titulo, String descripcion, TipoContenido tipoContenido,
                     Integer duracion, String urlDelRecurso, LocalDate fechaPublicacion,
                     String autor, Deporte deporte) {
        this.idContenido = idContenido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoContenido = tipoContenido;
        this.duracion = duracion;
        this.urlDelRecurso = urlDelRecurso;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.deporte = deporte;
    }

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

    public Deporte getDeporte() { return deporte; }
    public void setDeporte(Deporte deporte) { this.deporte = deporte; }
}
