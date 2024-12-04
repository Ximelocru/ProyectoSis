package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.Date;
import java.util.List;

import lombok.ToString;

@ToString
public class OrdenCompra {

    private Integer id;
    private Date fechaCreacion;
    private String estado;
    private Date fechaEntrega;
    private List<String> productos;
    private List<RecepcionProductos> RecepcionProductos;

    public OrdenCompra()
    {;}
    
    public OrdenCompra(Integer id, Date fechaCreacion, String estado, Date fechaEntrega, List<String> productos,
            List<RecepcionProductos> RecepcionProductos) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.productos = productos;
        this.RecepcionProductos = RecepcionProductos;
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
    public List<String> getProducto() {
        return productos;
    }
    public void setProducto(List<String> productos) {
        this.productos = productos;
    }
    public List<RecepcionProductos> getRecepcionProductos() {
        return RecepcionProductos;
    }
    public void setRecepcionProductos(List<RecepcionProductos> RecepcionProductos) {
        this.RecepcionProductos = RecepcionProductos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

}
