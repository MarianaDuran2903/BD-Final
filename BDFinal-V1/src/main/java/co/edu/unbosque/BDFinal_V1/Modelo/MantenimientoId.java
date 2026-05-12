package co.edu.unbosque.BDFinal_V1.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MantenimientoId implements Serializable {

    @Column(name = "OPERADOR_cedula", length = 15)
    private String operadorCedula;

    @Column(name = "MAQUINAS_codigo_serie")
    private Integer maquinasCodigoSerie;

    public MantenimientoId() {}

    public MantenimientoId(String operadorCedula, Integer maquinasCodigoSerie) {
        this.operadorCedula = operadorCedula;
        this.maquinasCodigoSerie = maquinasCodigoSerie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MantenimientoId)) return false;
        MantenimientoId that = (MantenimientoId) o;
        return Objects.equals(operadorCedula, that.operadorCedula)
                && Objects.equals(maquinasCodigoSerie, that.maquinasCodigoSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operadorCedula, maquinasCodigoSerie);
    }

    public String getOperadorCedula() { return operadorCedula; }
    public void setOperadorCedula(String operadorCedula) { this.operadorCedula = operadorCedula; }

    public Integer getMaquinasCodigoSerie() { return maquinasCodigoSerie; }
    public void setMaquinasCodigoSerie(Integer maquinasCodigoSerie) { this.maquinasCodigoSerie = maquinasCodigoSerie; }
}
