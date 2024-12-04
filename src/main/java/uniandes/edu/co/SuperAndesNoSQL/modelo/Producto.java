package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.Date;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection="productos")

public class Producto {
    @Id
    private int id;
    private Integer codBarras;
    private String nombre;
    private Integer precioUnitarioVenta;
    private String presentacion;
    private Integer cantidadPresentacio;
    private Integer unidadMedia;
    private Date fechaExpiracion;
    private EspecificacionesEmpacado id_expecificacionesEmpacado;
    private Integer id_categoria;
    public Producto()
    {;}

    public Producto(String nombre, Integer precioUnitarioVenta, String presentacion,Integer cantidadPresentacio, Integer unidadMedia, Date fechaExpiracion, 
    EspecificacionesEmpacado id_expecificacionesEmpacado, Integer id_categoria ) {
        this.nombre = nombre;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.presentacion= presentacion;
        this.cantidadPresentacio= cantidadPresentacio;
        this.unidadMedia= unidadMedia;
        this.fechaExpiracion= fechaExpiracion;
        this.id_expecificacionesEmpacado = id_expecificacionesEmpacado;
        this.id_categoria = id_categoria;

    }

    public Integer getCodBarras() {
        return codBarras;
    }
    public int getId() {
        return id;
    }


    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Integer precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Integer getCantidadPresentacio() {
        return cantidadPresentacio;
    }

    public void setCantidadPresentacio(Integer cantidadPresentacio) {
        this.cantidadPresentacio = cantidadPresentacio;
    }

    public Integer getUnidadMedia() {
        return unidadMedia;
    }

    public void setUnidadMedida(Integer unidadMedia) {
        this.unidadMedia = unidadMedia;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EspecificacionesEmpacado getid_expecificacionesEmpacado() {
        return id_expecificacionesEmpacado;
    }

    public void setid_expecificacionesEmpacado(EspecificacionesEmpacado id_expecificacionesEmpacado) {
        this.id_expecificacionesEmpacado = id_expecificacionesEmpacado;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

}
