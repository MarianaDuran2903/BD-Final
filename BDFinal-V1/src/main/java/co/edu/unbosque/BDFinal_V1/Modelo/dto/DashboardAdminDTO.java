package co.edu.unbosque.BDFinal_V1.Modelo.dto;

import java.math.BigDecimal;

public class DashboardAdminDTO {

    private Long totalMiembros;
    private Long totalEntrenadores;
    private Long totalOperadores;
    private Long totalClases;
    private Long clasesActivas;
    private Long totalMaquinas;
    private Long maquinasEnMantenimiento;
    private Long totalMembresiasActivas;
    private BigDecimal ingresosMes;

    public DashboardAdminDTO() {}

    public DashboardAdminDTO(Long totalMiembros, Long totalEntrenadores, Long totalOperadores,
                             Long totalClases, Long clasesActivas, Long totalMaquinas,
                             Long maquinasEnMantenimiento, Long totalMembresiasActivas,
                             BigDecimal ingresosMes) {
        this.totalMiembros = totalMiembros;
        this.totalEntrenadores = totalEntrenadores;
        this.totalOperadores = totalOperadores;
        this.totalClases = totalClases;
        this.clasesActivas = clasesActivas;
        this.totalMaquinas = totalMaquinas;
        this.maquinasEnMantenimiento = maquinasEnMantenimiento;
        this.totalMembresiasActivas = totalMembresiasActivas;
        this.ingresosMes = ingresosMes;
    }

    public Long getTotalMiembros() { return totalMiembros; }
    public void setTotalMiembros(Long totalMiembros) { this.totalMiembros = totalMiembros; }

    public Long getTotalEntrenadores() { return totalEntrenadores; }
    public void setTotalEntrenadores(Long totalEntrenadores) { this.totalEntrenadores = totalEntrenadores; }

    public Long getTotalOperadores() { return totalOperadores; }
    public void setTotalOperadores(Long totalOperadores) { this.totalOperadores = totalOperadores; }

    public Long getTotalClases() { return totalClases; }
    public void setTotalClases(Long totalClases) { this.totalClases = totalClases; }

    public Long getClasesActivas() { return clasesActivas; }
    public void setClasesActivas(Long clasesActivas) { this.clasesActivas = clasesActivas; }

    public Long getTotalMaquinas() { return totalMaquinas; }
    public void setTotalMaquinas(Long totalMaquinas) { this.totalMaquinas = totalMaquinas; }

    public Long getMaquinasEnMantenimiento() { return maquinasEnMantenimiento; }
    public void setMaquinasEnMantenimiento(Long maquinasEnMantenimiento) { this.maquinasEnMantenimiento = maquinasEnMantenimiento; }

    public Long getTotalMembresiasActivas() { return totalMembresiasActivas; }
    public void setTotalMembresiasActivas(Long totalMembresiasActivas) { this.totalMembresiasActivas = totalMembresiasActivas; }

    public BigDecimal getIngresosMes() { return ingresosMes; }
    public void setIngresosMes(BigDecimal ingresosMes) { this.ingresosMes = ingresosMes; }
}
