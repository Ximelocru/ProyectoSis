package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class DetalleCostoBodega {

    private Integer costoUnitarioBodega;
    private Integer cantidadExistencias;

    public DetalleCostoBodega()
    {;}
    
    public DetalleCostoBodega(Integer costoUnitarioBodega, Integer cantidadExistencias) {
        this.costoUnitarioBodega = costoUnitarioBodega;
        this.cantidadExistencias = cantidadExistencias;
    }
    public Integer getCostoUnitarioBodega() {
        return costoUnitarioBodega;
    }
    public void setCostoUnitarioBodega(Integer costoUnitarioBodega) {
        this.costoUnitarioBodega = costoUnitarioBodega;
    }
    public Integer getCantidadExistencias() {
        return cantidadExistencias;
    }
    public void setCantidadExistencias(Integer cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }
}
