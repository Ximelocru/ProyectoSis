package uniandes.edu.co.SuperAndesNoSQL.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Document(collection="proveedores")
public class Proveedor {

    @Id
    private Integer nit;
    private String nombre;
    private String direccion;
    private String nombreContacto;
    private Integer telefonoContacto;
    private List<InfoExtraProveedor> infoExtraProveedor;

    public Proveedor()
    {;}

    public Proveedor(Integer nit, String nombre, String direccion, String nombreContacto, Integer telefonoContacto,
            List<InfoExtraProveedor> infoExtraProveedor) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.infoExtraProveedor = infoExtraProveedor;
    }
    public Integer getNit() {
        return nit;
    }
    public void setNit(Integer nit) {
        this.nit = nit;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombreContacto() {
        return nombreContacto;
    }
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public Integer getTelefonoContacto() {
        return telefonoContacto;
    }
    public void setTelefonoContacto(Integer telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    public List<InfoExtraProveedor> getInfoExtraProveedor() {
        return infoExtraProveedor;
    }
    public void setInfoExtraProveedor(List<InfoExtraProveedor> infoExtraProveedor) {
        this.infoExtraProveedor = infoExtraProveedor;
    }

    
}
