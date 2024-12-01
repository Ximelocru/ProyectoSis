package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class DetalleCostoBodega {

    private Double costoUnitarioBodega;
    private Integer cantidadExistencias;

    public DetalleCostoBodega()
    {;}
    
    public DetalleCostoBodega(Double costoUnitarioBodega, Integer cantidadExistencias) {
        this.costoUnitarioBodega = costoUnitarioBodega;
        this.cantidadExistencias = cantidadExistencias;
    }
    public Double getCostoUnitarioBodega() {
        return costoUnitarioBodega;
    }
    public void setCostoUnitarioBodega(Double costoUnitarioBodega) {
        this.costoUnitarioBodega = costoUnitarioBodega;
    }
    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }
    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }
}
