package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;
import jakarta.validation.constraints.*;

public class RestriccionMedicaRequestDTO {

    @NotNull
    private TipoRestriccion tipo;

    @NotBlank @Size(max = 200)
    private String descripcion;

    @NotNull
    private NivelGravedad nivelGravedad;

    @NotBlank @Size(max = 200)
    private String recomendaciones;

    @NotBlank @Size(max = 15)
    private String miembroCedula;

    public RestriccionMedicaRequestDTO() {}

    public RestriccionMedicaRequestDTO(TipoRestriccion tipo, String descripcion,
                                       NivelGravedad nivelGravedad, String recomendaciones,
                                       String miembroCedula) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelGravedad = nivelGravedad;
        this.recomendaciones = recomendaciones;
        this.miembroCedula = miembroCedula;
    }

    public TipoRestriccion getTipo() { return tipo; }
    public void setTipo(TipoRestriccion tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public NivelGravedad getNivelGravedad() { return nivelGravedad; }
    public void setNivelGravedad(NivelGravedad nivelGravedad) { this.nivelGravedad = nivelGravedad; }

    public String getRecomendaciones() { return recomendaciones; }
    public void setRecomendaciones(String recomendaciones) { this.recomendaciones = recomendaciones; }

    public String getMiembroCedula() { return miembroCedula; }
    public void setMiembroCedula(String miembroCedula) { this.miembroCedula = miembroCedula; }
}
