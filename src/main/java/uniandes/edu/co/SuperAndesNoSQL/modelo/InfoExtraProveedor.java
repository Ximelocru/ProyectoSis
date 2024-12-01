package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class InfoExtraProveedor {

    private Producto producto;
    private Integer cantidadExistentes;

    public InfoExtraProveedor()
    {;}
    
    public InfoExtraProveedor(Producto producto, Integer cantidadExistentes) {
        this.producto = producto;
        this.cantidadExistentes = cantidadExistentes;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidadExistentes() {
        return cantidadExistentes;
    }
    public void setCantidadExistentes(Integer cantidadExistentes) {
        this.cantidadExistentes = cantidadExistentes;
    }
    
}
