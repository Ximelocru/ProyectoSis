package uniandes.edu.co.SuperAndesNoSQL.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.SuperAndesNoSQL.modelo.InfoExtraOrden;
import uniandes.edu.co.SuperAndesNoSQL.modelo.OrdenCompra;
import uniandes.edu.co.SuperAndesNoSQL.modelo.Sucursal;

@Repository
public interface SucursalRepository extends MongoRepository<Sucursal, String> {
    
    @Query("{ '_id': ?0 }")
    @Update("{ '$push': { 'ordenesCompra': ?1, 'infoExtraOrden': { $each: ?2 } } }")
    void agregarOrdenDeCompra(String sucursalId, OrdenCompra ordenCompra, List<InfoExtraOrden> infoExtraOrden); 

    @Query("{ 'OrdenesCompra.id': ?0 }")
    Sucursal findByOrdenCompraId(Integer ordenCompraId);

    @Query("{ '_id': ?0 }")
    Sucursal buscarPorId(String id);
}
    