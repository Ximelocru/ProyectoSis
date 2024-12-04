package uniandes.edu.co.SuperAndesNoSQL.modelo;

import lombok.ToString;

@ToString
public class InfoExtraProveedor {

    private String producto;
    private Integer cantidadExistentes;

    public InfoExtraProveedor()
    {;}
    
    public InfoExtraProveedor(String producto, Integer cantidadExistentes) {
        this.producto = producto;
        this.cantidadExistentes = cantidadExistentes;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public Integer getCantidadExistentes() {
        return cantidadExistentes;
    }
    public void setCantidadExistentes(Integer cantidadExistentes) {
        this.cantidadExistentes = cantidadExistentes;
    }
    
}
