package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document(collection="sucursales")
public class Sucursal {

    @Id
    private Integer id;
    private String nombre;
    private Integer tamanio;
    private String direccion;
    private String telefono;
    private Proveedor proveedor;
    private Bodega bodega;
    private OrdenCompra ordenCompra;
    private List<InfoExtraOrden> infoExtraOrden;
    private Ciudad ciudad;

    public Sucursal()
    {;}
    
    public Sucursal(Integer id, String nombre, Integer tamanio, String direccion, String telefono, Proveedor proveedor,
            Bodega bodega, OrdenCompra ordenCompra, List<InfoExtraOrden> infoExtraOrden, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.proveedor = proveedor;
        this.bodega = bodega;
        this.ordenCompra = ordenCompra;
        this.infoExtraOrden = infoExtraOrden;
        this.ciudad = ciudad;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getTamanio() {
        return tamanio;
    }
    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public Bodega getBodega() {
        return bodega;
    }
    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }
    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
    public List<InfoExtraOrden> getInfoExtraOrden() {
        return infoExtraOrden;
    }
    public void setInfoExtraOrden(List<InfoExtraOrden> infoExtraOrden) {
        this.infoExtraOrden = infoExtraOrden;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    
}
