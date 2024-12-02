package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.Date;
import java.util.List;

import lombok.ToString;

@ToString
public class OrdenCompra {

    private Date fechaCreacion;
    private String estado;
    private Date fechaEntrega;
    private List<Integer> productos;
    private List<RecepcionProductos> recepcionProductos;

    public OrdenCompra()
    {;}
    
    public OrdenCompra(Date fechaCreacion, String estado, Date fechaEntrega, List<Integer> productos,
            List<RecepcionProductos> recepcionProductos) {
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.productos = productos;
        this.recepcionProductos = recepcionProductos;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public List<Integer> getProducto() {
        return productos;
    }
    public void setProducto(List<Integer> productos) {
        this.productos = productos;
    }
    public List<RecepcionProductos> getRecepcionProductos() {
        return recepcionProductos;
    }
    public void setRecepcionProductos(List<RecepcionProductos> recepcionProductos) {
        this.recepcionProductos = recepcionProductos;
    }

    

}
