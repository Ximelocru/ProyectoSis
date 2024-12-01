package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class InfoExtraBodega {

    private Producto idProducto;
    private Integer cantidad;
    private Integer costoUnitarioCompra;
    private DetalleCostoBodega detalleCostoBodega;

    public InfoExtraBodega()
    {;}    

    public InfoExtraBodega(Producto idProducto, Integer cantidad, Integer costoUnitarioCompra, DetalleCostoBodega detalleCostoBodega) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costoUnitarioCompra = costoUnitarioCompra;
        this.detalleCostoBodega = detalleCostoBodega;
    }
    public Producto getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Integer getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }
    public void setCostoUnitarioCompra(Integer costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }

    public DetalleCostoBodega getDetalleCostoBodega() {
        return detalleCostoBodega;
    }

    public void setDetalleCostoBodega(DetalleCostoBodega detalleCostoBodega) {
        this.detalleCostoBodega = detalleCostoBodega;
    }
}
