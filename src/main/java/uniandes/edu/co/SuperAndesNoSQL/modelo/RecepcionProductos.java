package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.Date;

import lombok.ToString;

@ToString
public class RecepcionProductos {

    private String Bodega;
    private Date fechaRecepcion;

    public RecepcionProductos()
    {;}

    public RecepcionProductos(String Bodega, Date fechaRecepcion) {
        this.Bodega = Bodega;
        this.fechaRecepcion = fechaRecepcion;
    }
    public String getBodega() {
        return Bodega;
    }
    public void setBodega(String Bodega) {
        this.Bodega = Bodega;
    }
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
}
