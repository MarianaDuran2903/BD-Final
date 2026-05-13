package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import co.edu.unbosque.BDFinal_V1.Modelo.emun.NivelGravedad;
import co.edu.unbosque.BDFinal_V1.Modelo.emun.TipoRestriccion;

public class RestriccionMedicaResponseDTO {

    private Integer idRestriccion;
    private TipoRestriccion tipo;
    private String descripcion;
    private NivelGravedad nivelGravedad;
    private String recomendaciones;
    private String miembroCedula;

    public RestriccionMedicaResponseDTO() {}

    public RestriccionMedicaResponseDTO(Integer idRestriccion, TipoRestriccion tipo,
                                        String descripcion, NivelGravedad nivelGravedad,
                                        String recomendaciones, String miembroCedula) {
        this.idRestriccion = idRestriccion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelGravedad = nivelGravedad;
        this.recomendaciones = recomendaciones;
        this.miembroCedula = miembroCedula;
    }

    public Integer getIdRestriccion() { return idRestriccion; }
    public void setIdRestriccion(Integer idRestriccion) { this.idRestriccion = idRestriccion; }

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
