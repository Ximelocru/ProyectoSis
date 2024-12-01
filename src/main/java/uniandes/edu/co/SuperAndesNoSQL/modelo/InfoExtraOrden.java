package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class InfoExtraOrden {

    private Producto producto;
    private Integer cantidad;
    private Double costoUnitarioCompra;

    public InfoExtraOrden()
    {;}

    public InfoExtraOrden(Producto producto, Integer cantidad, Double costoUnitarioCompra) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoUnitarioCompra = costoUnitarioCompra;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getCostoUnitarioCompra() {
        return costoUnitarioCompra;
    }
    public void setCostoUnitarioCompra(Double costoUnitarioCompra) {
        this.costoUnitarioCompra = costoUnitarioCompra;
    }
    
}
