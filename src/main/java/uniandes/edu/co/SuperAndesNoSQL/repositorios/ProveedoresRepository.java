package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.SuperAndesNoSQL.modelo.InfoExtraProveedor;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Proveedor;

@Repository
public interface ProveedoresRepository extends MongoRepository<Proveedor, String> {

    @Query("{ $insert: { nit: ?0, nombre: ?1, direccion: ?2, nombreContacto: ?3, telefonoContacto: ?4, infoExtraProveedor: ?5 } }")
    void insertarProveedor(Integer nit, String nombre, String direccion, String nombreContacto, int telefonoContacto, List<InfoExtraProveedor> infoExtraProveedor);

    @Query(value = "{nit: ?0}", delete = true)
    void eliminarProveedorPorNit(int nit);

}
