package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.Date;

import lombok.ToString;

@ToString
public class RecepcionProductos {

    private Bodega bodega;
    private Date fechaRecepcion;

    public RecepcionProductos()
    {;}

    public RecepcionProductos(Bodega bodega, Date fechaRecepcion) {
        this.bodega = bodega;
        this.fechaRecepcion = fechaRecepcion;
    }
    public Bodega getBodega() {
        return bodega;
    }
    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
}
