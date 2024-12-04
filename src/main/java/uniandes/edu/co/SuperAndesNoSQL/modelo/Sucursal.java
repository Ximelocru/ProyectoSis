package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.List;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection="sucursales")
public class Sucursal {

    @Id
    private String id;
    private String nombre;
    private Integer tamanio;
    private String direccion;
    private String telefono;
    private Integer Proveedor;
    private String Bodega;
    private List<OrdenCompra> ordenesCompra;
    private List<InfoExtraOrden> infoExtraOrden;
    private Ciudad ciudad;

    public Sucursal()
    {;}
    
    public Sucursal(String id, String nombre, Integer tamanio, String direccion, String telefono, Integer Proveedor,
            String bodega, List<OrdenCompra> ordenesCompra, List<InfoExtraOrden> infoExtraOrden, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.Proveedor = Proveedor;
        this.Bodega = bodega;
        this.ordenesCompra = ordenesCompra;
        this.infoExtraOrden = infoExtraOrden;
        this.ciudad = ciudad;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public Integer getProveedor() {
        return Proveedor;
    }
    public void setProveedor(Integer Proveedor) {
        this.Proveedor = Proveedor;
    }
    public String getBodega() {
        return Bodega;
    }
    public void setBodega(String bodega) {
        this.Bodega = bodega;
    }
    public List<OrdenCompra> getOrdenCompra() {
        return ordenesCompra;
    }
    public void setOrdenCompra(List<OrdenCompra> ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
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
