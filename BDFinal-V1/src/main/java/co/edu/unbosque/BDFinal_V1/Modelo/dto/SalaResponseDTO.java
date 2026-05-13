package co.edu.unbosque.BDFinal_V1.Modelo.dto;

public class SalaResponseDTO {

    private Integer idSala;
    private Short capacidad;

    public SalaResponseDTO() {}

    public SalaResponseDTO(Integer idSala, Short capacidad) {
        this.idSala = idSala;
        this.capacidad = capacidad;
    }

    public Integer getIdSala() { return idSala; }
    public void setIdSala(Integer idSala) { this.idSala = idSala; }

    public Short getCapacidad() { return capacidad; }
    public void setCapacidad(Short capacidad) { this.capacidad = capacidad; }
}
