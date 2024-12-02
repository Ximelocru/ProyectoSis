package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class InfoExtraOrden {

    private String producto;
    private Integer cantidad;
    private Integer costoUnitarioCompra;

    public InfoExtraOrden()
    {;}

    public InfoExtraOrden(String producto, Integer cantidad, Integer costoUnitarioCompra) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costoUnitarioCompra = costoUnitarioCompra;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
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
    
}
